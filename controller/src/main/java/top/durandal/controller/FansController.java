package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.FansService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Fans;

import java.util.List;

@RestController
@RequestMapping("fans")
public class FansController {

    @Reference
    FansService fansService;

    @GetMapping("isFollow")
    public ResponseInfo isFollow(Integer userId,Integer followId){
        Boolean fans = fansService.getFans(userId, followId);
        if (!fans){
            return ResponseInfo.error(false);
        }
        return ResponseInfo.success(true);
    }

    @GetMapping("getAllFans")
    public ResponseInfo getAllFans(Integer userId){
        List<Fans> allFans = fansService.getAllFans(userId);
        if (allFans==null){
            return ResponseInfo.error("没有粉丝");
        }
        return ResponseInfo.success(allFans);
    }

    @GetMapping("getAllFollow")
    public ResponseInfo getAllFollow(Integer userId){
        List<Fans> allFollow = fansService.getAllFollow(userId);
        if (allFollow==null){
            return ResponseInfo.error("没有关注列表");
        }
        return ResponseInfo.success(allFollow);
    }
}
