package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.User;
import top.durandal.api.service.UserService;
import top.durandal.statictext.StaticText;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("用户操作")
public class UserController {

    @Reference
    UserService userService;

    @PostMapping("/save")
    @ApiOperation(value = "注册用户",notes = "<p style='color: red'>描述：</p>注册用户个人信息")
    public ResponseInfo saveUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseInfo.error("请填写正确的信息注册");
        } else if (userService.saveUser(user)){
            return ResponseInfo.success(userService.queryByName(user.getUserName()));
        }
        return ResponseInfo.error("用户名已存在");
    }

    @PostMapping("/login")
    @ApiOperation(value ="用户登录",notes = StaticText.APITEXT+"用户登录")
    public ResponseInfo userLogin(Authentication authentication){
        User user = userService.queryByName(authentication.getName());
        return ResponseInfo.success(user);
    }

    @PostMapping("change")
    public ResponseInfo changePass(String userName,String userEmail,String newUserPass){
        String msg = userService.changePass(userName, userEmail, newUserPass);
        if (msg==null){
            return ResponseInfo.success("修改成功!您的新密码是:"+newUserPass);
        }
        return ResponseInfo.error(msg);
    }

    @DeleteMapping("ban")
    public ResponseInfo banByName(String userName){
        Integer hasUser = userService.banByName(userName);
        if (hasUser>0){
        return ResponseInfo.success("禁用成功");
        }else if (hasUser<0){
            return ResponseInfo.error("禁用的用户不存在");
        }
        return ResponseInfo.error("用户已经被禁用，不可以再次禁用");
    }

    @PostMapping("relieve")
    public ResponseInfo relieveByName(String userName){
        Integer hasUser = userService.relieveByName(userName);
        if (hasUser>0){
            return ResponseInfo.success("解除用户封禁");
        }else if (hasUser<0){
            ResponseInfo.error("解禁的用户不存在");
        }
        return ResponseInfo.error("用户未处于封禁状态");
    }

    @GetMapping("getUserByName")
    public ResponseInfo getUserByName(String userName){
        User userByName = userService.getUserByName(userName);
        if (userByName!=null){
        return ResponseInfo.success(userByName);
        }
        return ResponseInfo.error("用户不存在");
    }

    @GetMapping("getUserById")
    public ResponseInfo getUserById(Integer userId){
        User userById = userService.getUserById(userId);
        if (userById==null){
            return ResponseInfo.error("没有找到任何用户");
        }
        return ResponseInfo.success(userById);
    }

    @PostMapping("updateEmail")
    public ResponseInfo updateEmail(@Param("userId") Integer userId, @Param("userEmail") String userEmail){
        User user = userService.updateEmail(userId, userEmail);
        if (user==null){
            return ResponseInfo.error("没有用户信息");
        }
        return ResponseInfo.success(user);
    }
}
