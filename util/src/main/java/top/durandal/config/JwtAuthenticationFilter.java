package top.durandal.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import top.durandal.statictext.StaticText;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Resource
    RedisTemplate redisTemplate;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = getAuthentication(request);
        if (authentication == null) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(StaticText.TOKEN_HEADER);
        if (!StringUtils.isEmpty(token) && token.startsWith(StaticText.TOKEN_PREFIX)) {
            try {
                Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(StaticText.TOKEN_KEY.getBytes()).build()
                        .parseClaimsJws(token.replace(StaticText.TOKEN_PREFIX, ""));

                String userEmail = jws.getBody().getSubject();

                List<SimpleGrantedAuthority> role = new ArrayList<>();
                role.add(new SimpleGrantedAuthority("ROLE_USER"));

                if (!StringUtils.isEmpty(userEmail)) {
                    String getToken = (String) redisTemplate.opsForValue().get(userEmail);
                    if (!StringUtils.isEmpty(getToken)) {
                        return new UsernamePasswordAuthenticationToken(userEmail, null, role);
                    }else {
                        return null;
                    }
                }else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
