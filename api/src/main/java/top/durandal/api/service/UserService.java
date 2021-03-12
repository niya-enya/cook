package top.durandal.api.service;

import top.durandal.entity.User;

public interface UserService {

    Boolean saveUser(User user);

    User queryByName(String name);

    String changePass(String userName, String userEmail,String newUserPass);

    Integer banByName(String userName);

    Integer relieveByName(String userName);

    User getUserByName(String userName);

    User getUserById(Integer userId);

    User updateEmail(Integer userId, String userEmail);
}
