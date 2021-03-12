package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.FansService;
import top.durandal.dao.FansDao;
import top.durandal.entity.Fans;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class FansServiceImpl implements FansService {

    @Resource
    FansDao fansDao;

    public Fans queryById() {
        return null;
    }

    public List<Fans> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Fans insert(Fans fans) {
        return null;
    }

    public Fans update(Fans fans) {
        return null;
    }

    public boolean deleteById() {
        return false;
    }

    public Boolean getFans(Integer userId,Integer followId) {
        List<Integer> fans = fansDao.getFans(followId);
        for (Integer temp:fans) {
            if (temp.equals(userId)){
                return true;
            }
        }
        return false;
    }

    public List<Fans> getAllFans(Integer userId) {
        List<Fans> allFans = fansDao.getAllFans(userId);
        if (allFans.size()!=0){
            return allFans;
        }
        return null;
    }

    public List<Fans> getAllFollow(Integer userId) {
        List<Fans> allFollow = fansDao.getAllFollow(userId);
        if (allFollow.size()!=0){
            return allFollow;
        }
        return null;
    }
}
