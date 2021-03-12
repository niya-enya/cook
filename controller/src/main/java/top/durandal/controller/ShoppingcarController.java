package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.ShoppingcarService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Shoppingcar;

import java.util.List;

@RestController
@RequestMapping("cart")
public class ShoppingcarController {

    @Reference
    ShoppingcarService shoppingcarService;

    @PostMapping("insert")
    public ResponseInfo insertCart(@RequestBody Shoppingcar shoppingcar){
        Shoppingcar insert = shoppingcarService.insert(shoppingcar);
        if (insert==null){
            return ResponseInfo.error("没有插入成功");
        }
        return ResponseInfo.success(insert);
    }

    @GetMapping("getAllCartByUserId")
    public ResponseInfo getAllCartByUserId(Integer userId){
        List<Shoppingcar> allCartByUserId = shoppingcarService.getAllCartByUserId(userId);
        if (allCartByUserId==null){
            return ResponseInfo.error("没有购物车信息");
        }
        return ResponseInfo.success(allCartByUserId);
    }
}
