package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.ReceiveGiftService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.ReceiveGift;

@RestController
@RequestMapping("receiveGift")
@Api
public class ReceiveGiftController {

    @Reference
    ReceiveGiftService receiveGiftService;

    @PostMapping("insertReceiveGift")
    public ResponseInfo insertReceiveGift(@RequestBody ReceiveGift receiveGift){
        receiveGiftService.insert(receiveGift);
        return ResponseInfo.success("成功");
    }
}
