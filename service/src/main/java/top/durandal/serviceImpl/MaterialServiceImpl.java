package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.MaterialService;
import top.durandal.dao.MaterialDao;
import top.durandal.entity.Material;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class MaterialServiceImpl implements MaterialService {

    @Resource
    MaterialDao materialDao;

    public Material queryById(Integer materialId) {
        return null;
    }

    public List<Material> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Material insert(Material material) {
        return null;
    }

    public Material update(Material material) {
        return null;
    }

    public boolean deleteById(Integer materialId) {
        return false;
    }

    public List<Material> getMaterialByWorksId(int worksId) {
        List<Material> material = materialDao.getMaterialByWorksId(worksId);
        if (material.size()!=0){
            return material;
        }
        return null;
    }
}
