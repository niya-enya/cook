package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.OrderDetailsService;
import top.durandal.dao.OrderDetailsDao;
import top.durandal.entity.OrderDetails;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Resource
    OrderDetailsDao orderDetailsDao;

    public OrderDetails queryByOrdersId(Integer ordersId) {
        OrderDetails orderDetails = orderDetailsDao.queryByOrdersId(ordersId);
        return orderDetails;
    }

    public List<OrderDetails> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public OrderDetails insert(OrderDetails orderDetails) {
        return null;
    }

    public OrderDetails update(OrderDetails orderDetails) {
        return null;
    }

    public boolean deleteById() {
        return false;
    }
}
