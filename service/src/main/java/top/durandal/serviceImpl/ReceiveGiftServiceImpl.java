package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.ReceiveGiftService;
import top.durandal.dao.ReceiveGiftDao;
import top.durandal.entity.ReceiveGift;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class ReceiveGiftServiceImpl implements ReceiveGiftService {

    @Resource
    ReceiveGiftDao receiveGiftDao;

    public ReceiveGift queryById(Integer receiveGiftId) {
        return null;
    }

    public List<ReceiveGift> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public ReceiveGift insert(ReceiveGift receiveGift) {
        receiveGiftDao.insert(receiveGift);
        return null;
    }

    public ReceiveGift update(ReceiveGift receiveGift) {
        return null;
    }

    public boolean deleteById(Integer receiveGiftId) {
        return false;
    }
}
