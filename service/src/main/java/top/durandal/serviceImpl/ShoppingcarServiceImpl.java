package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.ShoppingcarService;
import top.durandal.dao.ShoppingcarDao;
import top.durandal.entity.Shoppingcar;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class ShoppingcarServiceImpl implements ShoppingcarService {

    @Resource
    ShoppingcarDao shoppingcarDao;

    public Shoppingcar queryById(Integer shoppingcarId) {
        Shoppingcar queryById = shoppingcarDao.queryById(shoppingcarId);
        return queryById;
    }

    public List<Shoppingcar> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Shoppingcar insert(Shoppingcar shoppingcar) {
        int insert = shoppingcarDao.insert(shoppingcar);
        return shoppingcarDao.queryById(insert);
    }

    public Shoppingcar update(Shoppingcar shoppingcar) {
        return null;
    }

    public boolean deleteById(Integer shoppingcarId) {
        return false;
    }

    public List<Shoppingcar> getAllCartByUserId(Integer userId) {
        List<Shoppingcar> allCartByUserId = shoppingcarDao.getAllCartByUserId(userId);
        if (allCartByUserId.size()!=0){
            return allCartByUserId;
        }
        return null;
    }
}
