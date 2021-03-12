package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Fans;
import top.durandal.entity.User;

import java.util.List;

/**
 * (Fans)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:31
 */
@Mapper
@Repository
public interface FansDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Fans queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Fans> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fans 实例对象
     * @return 对象列表
     */
    List<Fans> queryAll(Fans fans);

    /**
     * 新增数据
     *
     * @param fans 实例对象
     * @return 影响行数
     */
    int insert(Fans fans);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fans> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fans> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fans> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Fans> entities);

    /**
     * 修改数据
     *
     * @param fans 实例对象
     * @return 影响行数
     */
    int update(Fans fans);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById();

    @Select("select fans_id from fans where user_id = #{userId}")
    List<Integer> getFans(Integer userId);

    @Select("select fans_id from fans where user_id = #{userId}")
    @Results({
            @Result(property = "fans",column = "fans_id",
            one = @One(select = "top.durandal.dao.UserDao.getUserById"))
    })
    List<Fans> getAllFans(Integer userId);

    @Select("select user_id from fans where fans_id = #{userId}")
    @Results({
            @Result(property = "user",column = "user_id",
                    one = @One(select = "top.durandal.dao.UserDao.getUserById"))
    })
    List<Fans> getAllFollow(Integer userId);
}