package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.SortService;
import top.durandal.dao.SortDao;
import top.durandal.entity.Sort;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class SortServiceImpl implements SortService {

    @Resource
    SortDao sortDao;

    public Sort queryById(Integer sortId) {
        return null;
    }

    public List<Sort> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Sort insert(Sort sort) {
        return null;
    }

    public Sort update(Sort sort) {
        return null;
    }

    public boolean deleteById(Integer sortId) {
        return false;
    }

    public List<Sort> queryAll() {
        List<Sort> sorts = sortDao.queryAll();
        if (sorts!=null){
            return sorts;
        }
        return null;
    }
}
