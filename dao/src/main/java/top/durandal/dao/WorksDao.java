package top.durandal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Works;

import java.util.List;

/**
 * (Works)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:40
 */
@Mapper
@Repository
public interface WorksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param worksId 主键
     * @return 实例对象
     */
    @Select("select * from works where works_id = #{worksId}")
    Works queryById(Integer worksId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Works> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param works 实例对象
     * @return 对象列表
     */
    List<Works> queryAll(Works works);

    /**
     * 新增数据
     *
     * @param works 实例对象
     * @return 影响行数
     */
    @Insert("insert into works (work_id,user_id,sort_id,works_time,works_title,works_show,works_type,works_describe) " +
            "values(#{worksId},#{userId},#{sortId},#{worksTime},#{worksTitle},#{worksShow},#{worksType},#{worksDescribe})")
    int insert(Works works);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Works> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Works> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Works> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Works> entities);

    /**
     * 修改数据
     *
     * @param works 实例对象
     * @return 影响行数
     */
    int update(Works works);

    /**
     * 通过主键删除数据
     *
     * @param worksId 主键
     * @return 影响行数
     */
    int deleteById(Integer worksId);

    /**
     * 按照时间排序查找最新，按照类型分别查找文章
     * @return
     */
    @Select("select * from works where works_type='图文' order by works_time desc limit 0,4")
    List<Works> getWorksArticleByTime();

    /**
     * 按照时间排序查找，按照类型找视频
     * @return
     * works_id,user_id,sort_id,works_author,works_time,works_title,works_cover,works_type,works_describe
     */
    @Select("select * from works where works_type='视频' order by works_time desc limit 0,4")
    List<Works> getWorksVideoByTime();

    /**
     * 通过分类id获得所有此分类的作品
     * @param sortId
     * @return
     */
    @Select("select * from works where works_type='图文' and sort_id = #{sortId}")
    List<Works> getWorksBySortId(int sortId);

    /**
     * 获得所有的视频
     * @return
     */
    @Select("select * from works where works_type=#{type}")
    List<Works> getWorksByType(String type);

    /**
     * 通过用户id获得该用户所有的作品
     * @param userId
     * @return
     */
    @Select("select * from works where user_id = #{userId}")
    List<Works> getWorksByUserId(int userId);
}