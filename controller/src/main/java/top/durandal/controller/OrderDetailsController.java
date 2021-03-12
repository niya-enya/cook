package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.OrderDetailsService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.OrderDetails;

@RestController
@RequestMapping("OrderDetails")
public class OrderDetailsController {

    @Reference
    OrderDetailsService orderDetailsService;

    @GetMapping("getOrderDetailsByOrdersId")
    public ResponseInfo getOrderDetailsByOrdersId(int ordersId){
        OrderDetails orderDetails = orderDetailsService.queryByOrdersId(ordersId);
        if (orderDetails==null){
            return ResponseInfo.error("没有订单信息");
        }
        return ResponseInfo.success(orderDetails);
    }


}
