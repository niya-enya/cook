package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.AddressService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Address;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Reference
    AddressService addressService;

    @GetMapping("getAddressByUserId")
    public ResponseInfo getAddressByUserId(Integer userId){
        List<Address> allAddress= addressService.getAddressByUserId(userId);
        if (allAddress==null){
            return ResponseInfo.error("该用户没有添加地址");
        }
        return ResponseInfo.success(allAddress);
    }

    @PostMapping("insertAddress")
    public ResponseInfo insertAddress(@RequestBody Address address){
        Address insert = addressService.insert(address);
        if (insert==null){
            return ResponseInfo.error("插入失败");
        }
        return ResponseInfo.success(insert);
    }

    @PostMapping("updateAddress")
    public ResponseInfo updateAddress(@RequestBody Address address){
        Address update = addressService.update(address);
        if (update==null){
            return ResponseInfo.error("没有该的地址信息，不可以更新");
        }
        return ResponseInfo.success(address);
    }
}
