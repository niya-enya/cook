package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.VideoService;
import top.durandal.dao.VideoDao;
import top.durandal.entity.Video;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class VideoServiceImpl implements VideoService {

    @Resource
    VideoDao videoDao;

    public List<Video> getVideoByWorksId(int worksId) {
        List<Video> videoByWorksId = videoDao.getVideoByWorksId(worksId);
        if (videoByWorksId.size()!=0){
            return videoByWorksId;
        }
        return null;
    }

    public List<Video> getVideos() {
        return videoDao.getVideos();
    }
}
