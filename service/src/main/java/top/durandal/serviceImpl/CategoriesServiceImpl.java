package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.CategoriesService;
import top.durandal.dao.CategoriesDao;
import top.durandal.entity.Categories;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class CategoriesServiceImpl implements CategoriesService {

    @Resource
    CategoriesDao categoriesDao;

    public Categories queryById(Integer categoriesId) {
        Categories categories = categoriesDao.queryById(categoriesId);
        if (categories!=null){
            return categories;
        }
        return null;
    }

    public List<Categories> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Categories insert(Categories categories) {
        return null;
    }

    public Categories update(Categories categories) {
        return null;
    }

    public boolean deleteById(Integer categoriesId) {
        return false;
    }

    public List<Categories> getAll() {
        List<Categories> all = categoriesDao.getAll();
        if (all.size()!=0){
            return all;
        }
        return null;
    }
}
