package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.GoodsService;
import top.durandal.dao.GoodsDao;
import top.durandal.entity.Goods;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsDao goodsDao;

    public Goods queryById(Integer goodsId) {
        Goods goods = goodsDao.queryById(goodsId);
        return goods;
    }

    public List<Goods> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Goods insert(Goods goods) {
        return null;
    }

    public Goods update(Goods goods) {
        return null;
    }

    public boolean deleteById(Integer goodsId) {
        return false;
    }

    public List<Goods> getGoods(int startPage) {
        int start = (startPage-1)*12;
        List<Goods> goods = goodsDao.getGoods(start);
        if (goods.size()!=0){
            return goods;
        }
        return null;
    }
}
