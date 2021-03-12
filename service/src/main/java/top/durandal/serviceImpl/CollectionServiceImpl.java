package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.CollectionService;
import top.durandal.dao.CollectionDao;
import top.durandal.entity.Collection;
import top.durandal.entity.Works;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class CollectionServiceImpl implements CollectionService {

    @Resource
    CollectionDao collectionDao;

    public List getCollectionByWorksId(int worksId) {
        List collectionUser = collectionDao.getCollectionByWorksId(worksId);
        if (collectionUser.size()!=0){
            return collectionUser;
        }
        return null;
    }

    public List<Collection> getAllCollection(Integer userId) {
        List<Collection> allCollection = collectionDao.getAllCollection(userId);
        if (allCollection.size()!=0){
            return allCollection;
        }
        return null;
    }

    public int insertCollection(Integer userId, Integer worksId) {
        int changeLine = collectionDao.insertCollection(userId, worksId);
        return changeLine;
    }

    public int delete(Integer userId, Integer worksId) {
        int deleteNum = collectionDao.delete(userId, worksId);
        return deleteNum;
    }
}
