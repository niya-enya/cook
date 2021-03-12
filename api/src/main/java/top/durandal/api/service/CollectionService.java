package top.durandal.api.service;

import top.durandal.entity.Collection;
import top.durandal.entity.Works;

import java.util.List;

public interface CollectionService {
    /**
     * 通过worksId获得所有的收藏信息
     * @param worksId
     */
    List getCollectionByWorksId(int worksId);

    List<Collection> getAllCollection(Integer userId);

    int insertCollection(Integer userId, Integer worksId);

    int delete(Integer userId, Integer worksId);
}
