package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.CollectionService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Collection;

import java.util.List;

@RestController
@RequestMapping("collection")
public class CollectionController {

    @Reference
    CollectionService collectionService;

    @GetMapping("getCollectionByWorksId")
    public ResponseInfo getCollectionByUserId(int worksId){
        List collectionUser = collectionService.getCollectionByWorksId(worksId);
        if (collectionUser == null) {
            return ResponseInfo.error("该作品没有被收藏");
        }
        return ResponseInfo.success(collectionUser);
    }

    @GetMapping("getAllCollection")
    public ResponseInfo getAllCollection(Integer userId){
        List<Collection> allCollection = collectionService.getAllCollection(userId);
        if (allCollection==null){
            return ResponseInfo.error("没有收藏");
        }
        return ResponseInfo.success(allCollection);
    }

    @PostMapping("insertCollection")
    public ResponseInfo insertCollection(@Param("userId") Integer userId,@Param("worksId") Integer worksId){
        int insert = collectionService.insertCollection(userId, worksId);
        if (insert==0){
            return ResponseInfo.error("插入失败");
        }
        return ResponseInfo.success("成功");
    }

    @DeleteMapping("deleteCollection")
    public ResponseInfo deleteCollection(@Param("userId") Integer userId,@Param("worksId") Integer worksId){
        int deleteNum = collectionService.delete(userId, worksId);
        if (deleteNum==0){
            return ResponseInfo.error("取消失败");
        }
        return ResponseInfo.success("取消成功");
    }
}
