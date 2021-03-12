package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.WorksService;
import top.durandal.dao.WorksDao;
import top.durandal.entity.Works;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Component
public class WorksServiceImpl implements WorksService {

    @Resource
    WorksDao worksDao;

    public Works queryById(Integer worksId) {
        Works works = worksDao.queryById(worksId);
        if (works!=null){
            return works;
        }
        return null;
    }

    public List<Works> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Works insert(Works works) {
        works.setWorksTime(new Date());
        worksDao.insert(works);
        return works;
    }

    public Works update(Works works) {
        return null;
    }

    public boolean deleteById(Integer worksId) {
        return false;
    }

    public List getWorksByTime() {
        List<Works> article = worksDao.getWorksArticleByTime();
        List<Works> video = worksDao.getWorksVideoByTime();
        if (article.size()==0 && video.size()==0){
            return null;
        }else if(article.size() == 0){
            return video;
        }else if (video.size()==0){
            return article;
        }
        List<List<Works>> workList=new ArrayList<List<Works>>();
        workList.add(article);
        workList.add(video);
        return workList;
    }

    public List<Works> getWorksBySortId(int sortId) {
        List<Works> worksArticleBySortId = worksDao.getWorksBySortId(sortId);
        if (worksArticleBySortId.size()!=0){
            return worksArticleBySortId;
        }
        return null;
    }

    public List<Works> getWorksByType(String type) {
        List<Works> allLive = worksDao.getWorksByType(type);
        if (allLive.size()!=0){
            return allLive;
        }
        return null;
    }

    public List<Works> getWorksByUserId(int userId) {
        List<Works> works = worksDao.getWorksByUserId(userId);
        System.out.println(works);
        if (works.size()!=0){
            return works;
        }
        return null;
    }


}
