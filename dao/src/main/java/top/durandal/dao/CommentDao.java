package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Comment;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:30
 */
@Mapper
@Repository
public interface CommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param comment 实例对象
     * @return 对象列表
     */
    List<Comment> queryAll(Comment comment);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    @Insert("insert into comment (works_id,user_from_id,user_to_id,comment_content,comment_date) " +
            "values(#{worksId},#{userFromId},#{userToId},#{commentContent},#{commentDate})")
    @Options(useGeneratedKeys = true,keyProperty = "worksId")
    int insert(Comment comment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Comment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Comment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Comment> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Comment> entities);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    int update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Integer commentId);

    /**
     * 通过workId查咋所有的评论
     * @param worksId
     * @return
     */
    @Select("select * from comment where works_id = #{workId}")
    @Results({
            @Result(property = "worksMsg",column = "works_id", one = @One(select = "top.durandal.dao.WorksDao.queryById")),
            @Result(property = "userFromMsg",column = "user_from_id", one = @One(select = "top.durandal.dao.UserDao.getUserById"))
    })
    List<Comment> getCommentByWorksId(int worksId);

    /**
     * 根据id查找用户收到的所有评论
     * @param userToId
     */
    @Select("select * from comment where user_to_id = #{userToId}")
    List<Comment> getCommentByUserId(Integer userToId);
}