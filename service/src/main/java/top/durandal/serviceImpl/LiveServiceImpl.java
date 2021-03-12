package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.LiveService;
import top.durandal.dao.LiveDao;
import top.durandal.entity.Live;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class LiveServiceImpl implements LiveService {

    @Resource
    LiveDao liveDao;

    public Live queryById(String liveId) {
        Live live = liveDao.queryById(liveId);
        return live;
    }

    public List<Live> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Live insert(Live live) {
        return null;
    }

    public Live update(Live live) {
        return null;
    }

    public boolean deleteById(String liveId) {
        return false;
    }

    public List<Live> getLiveByHeat() {
        List<Live> live = liveDao.getLiveByHeat();
        if (live.size() != 0) {
            return live;
        }
        return null;
    }

    public List<Live> getLive() {
        List<Live> live = liveDao.getLive();
        if (live.size() != 0) {
            return live;
        }
        return null;
    }

    public Live insertLive(Live live) {
        Live hasLive = liveDao.queryById(live.getLiveId());
        if (hasLive == null) {
            liveDao.insertLive(live);
        }else {
            liveDao.update(live);
        }
        return live;
    }
}
