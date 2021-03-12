package top.durandal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import top.durandal.dao.UserDao;
import top.durandal.entity.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    @Resource
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userDao.findByEmail(userEmail);
        if (user==null){
            throw new UsernameNotFoundException("not Found User");
        }
        List<GrantedAuthority>authorities =new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        org.springframework.security.core.userdetails.User userDetails
                =new org.springframework.security.core.userdetails.User(user.getUserEmail(),passwordEncoder.encode(user.getUserPass()),authorities);
        return userDetails;
        
    }
}
