package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Live;

import java.util.List;

/**
 * (Live)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:34
 */
@Mapper
@Repository
public interface LiveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param liveId 主键
     * @return 实例对象
     */
    @Select("select * from live where live_id = #{liveId}")
    Live queryById(String liveId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Live> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param live 实例对象
     * @return 对象列表
     */
    List<Live> queryAll(Live live);

    /**
     * 新增数据
     *
     * @param live 实例对象
     * @return 影响行数
     */
    int insert(Live live);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Live> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Live> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Live> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Live> entities);

    /**
     * 修改数据
     *
     * @param live 实例对象
     * @return 影响行数
     */
    @Update("update live set live_img=#{liveImg},live_title=#{liveTitle},live_state=#{liveState},live_number=#{liveNumber} where live_id=#{liveId}")
    int update(Live live);

    /**
     * 通过主键删除数据
     *
     * @param liveId 主键
     * @return 影响行数
     */
    int deleteById(String liveId);

    /**
     * 通过直播间人气获取最高的四个
     * @return
     */
    @Select("select * from live where live_state = 1 order by live_number desc limit 0 , 4 ")
    List<Live> getLiveByHeat();

    /**
     * 获得所有的直播间
     * @return
     */
    @Select("select * from live")
    List<Live> getLive();

    @Insert("insert into live (live_id,user_id,live_img,live_title,live_state,live_number) " +
            "values(#{liveId},#{userId},#{liveImg},#{liveTitle},#{liveState},#{liveNumber})")
    int insertLive(Live live);

    /**
     * 通过userId获得直播间号，子查询
     * @param userId
     * @return
     */
    @Select("select live_id from live where user_id = #{userId}")
    String getLiveId(Integer userId);
}