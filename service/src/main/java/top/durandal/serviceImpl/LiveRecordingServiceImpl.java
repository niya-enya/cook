package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.LiveRecordingService;
import top.durandal.dao.LiveDao;
import top.durandal.dao.LiveRecordingDao;
import top.durandal.entity.Live;
import top.durandal.entity.LiveRecording;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class LiveRecordingServiceImpl implements LiveRecordingService {

    @Resource
    LiveRecordingDao liveRecordingDao;
    @Resource
    LiveDao liveDao;

    public LiveRecording queryById(Integer liveRecordingId) {
        return null;
    }

    public List<LiveRecording> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public LiveRecording insert(LiveRecording liveRecording) {
        int isInsert = liveRecordingDao.insert(liveRecording);
        if (isInsert!=0){
            return liveRecording;
        }
        return null;
    }

    public LiveRecording update(LiveRecording liveRecording) {
        return null;
    }

    public boolean deleteById(Integer liveRecordingId) {
        return false;
    }

    public List<LiveRecording> getLiveRecordingByUserId(Integer userId) {
        String liveId = liveDao.getLiveId(userId);
        if (liveId==null){
            return null;
        }
        return liveRecordingDao.getLiveRecordingByUserId(liveId);
    }
}
