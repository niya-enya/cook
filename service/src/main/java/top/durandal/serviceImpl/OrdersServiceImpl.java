package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.OrdersService;
import top.durandal.dao.OrdersDao;
import top.durandal.entity.Orders;
import top.durandal.util.MakeOrderNumber;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class OrdersServiceImpl implements OrdersService {

    @Resource
    OrdersDao ordersDao;

    public Orders queryById(Integer ordersId) {
        return null;
    }

    public List<Orders> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Orders insert(Orders orders) {
        orders.setOrdersNumber(MakeOrderNumber.getOrderNumber());
        int isInsert = ordersDao.insert(orders);
        if (isInsert!=0){
            return orders;
        }
        return null;
    }

    public Orders update(Orders orders) {
        return null;
    }

    public boolean deleteById(Integer ordersId) {
        return false;
    }

    public List<Orders> getOrderByUserId(Integer userId) {
        List<Orders> allOrders = ordersDao.getAllOrdersByUserId(userId);
        if (allOrders.size()==0){
            return null;
        }
        return allOrders;
    }
}
