package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import top.durandal.dao.UserDao;
import top.durandal.entity.User;
import top.durandal.api.service.UserService;
import top.durandal.util.ReformatDate;

import java.util.Date;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Boolean saveUser(User user) {
        User hasUser = userDao.findByEmail(user.getUserEmail());
        if (hasUser == null) {
//            String pass = passwordEncoder.encode(user.getUserPass());
            user.setUserShow("true");
            user.setUserDate(new Date());
            userDao.saveUser(user);
            return true;
        } else {
            return false;
        }
    }

    public User queryByName(String name) {
        User user = userDao.queryByName(name);
        return user;
    }

    public String changePass(String userName, String userEmail, String newUserPass) {
        User user = userDao.queryByName(userName);
        if (user == null) {
            return "没有找到任何用户信息";
        } else if (!userEmail.equals(user.getUserEmail())) {
            return "验证邮箱失败，请重新验证";
        }
        userDao.updateByName(userName, passwordEncoder.encode(newUserPass));
        return null;
    }

    public Integer banByName(String userName) {
        String hasUser = userDao.hasUser(userName);
        if (hasUser == null) {
            return -1;
        } else if ("false".equals(hasUser)) {
            return 0;
        }
        userDao.banByName(userName);
        return 1;
    }

    public Integer relieveByName(String userName) {
        String hasUser = userDao.hasUser(userName);
        if (hasUser == null) {
            return -1;
        } else if ("false".equals(hasUser)) {
            userDao.relieveByName(userName);
            return 1;
        }
        return 0;
    }

    public User getUserByName(String userName) {
        User user = userDao.queryByName(userName);
        if (user != null) {
            return user;
        }
        return null;
    }

    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    public User updateEmail(Integer userId, String userEmail) {
        User userById = userDao.getUserById(userId);
        if (userById == null) {
            return null;
        }
        userDao.updateEmail(userId,userEmail);
        return userById;
    }


}
