package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Collection;
import top.durandal.entity.User;

import java.util.List;

/**
 * @author bianca-durandal-attagina
 */
@Mapper
@Repository
public interface CollectionDao {
    /**
     * 通过worksId获得所有的关注列表
     * @param worksId
     */
    @Select("select * from collection where works_id = #{worksId}")
    @Results({
            @Result(property = "userMsg",column = "user_id",one = @One(select = "top.durandal.dao.UserDao.getUserById")),
            @Result(property = "works",column = "works_id",one = @One(select = "top.durandal.dao.WorksDao.queryById"))
    })
    List<Collection> getCollectionByWorksId(int worksId);

    @Select("select works_id from collection where user_id = #{userId}")
    @Results({
            @Result(property = "works", column = "works_id",
            one = @One(select = "top.durandal.dao.WorksDao.queryById"))
    })
    List<Collection> getAllCollection(Integer userId);

    @Insert("insert into collection (user_id,works_id) values (#{userId},#{worksId})")
    int insertCollection(@Param("userId") Integer userId,@Param("worksId") Integer worksId);

    @Delete("delete from collection where user_id=#{userId} and works_id = #{worksId}")
    int delete(@Param("userId") Integer userId, @Param("worksId") Integer worksId);
}
