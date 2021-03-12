package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.LiveRecording;

import java.util.List;

/**
 * (LiveRecording)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:34
 */
@Mapper
@Repository
public interface LiveRecordingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param liveRecordingId 主键
     * @return 实例对象
     */
    LiveRecording queryById(Integer liveRecordingId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<LiveRecording> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param liveRecording 实例对象
     * @return 对象列表
     */
    List<LiveRecording> queryAll(LiveRecording liveRecording);

    /**
     * 新增数据
     *
     * @param liveRecording 实例对象
     * @return 影响行数
     */
    @Insert("insert into liveRecording (live_recording_id,live_id,live_time,live_video) values(#{liveRecordingId},#{liveId},#{liveTime},#{liveVideo})")
    int insert(LiveRecording liveRecording);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LiveRecording> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LiveRecording> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LiveRecording> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<LiveRecording> entities);

    /**
     * 修改数据
     *
     * @param liveRecording 实例对象
     * @return 影响行数
     */
    int update(LiveRecording liveRecording);

    /**
     * 通过主键删除数据
     *
     * @param liveRecordingId 主键
     * @return 影响行数
     */
    int deleteById(Integer liveRecordingId);

    /**
     * 获得所有直播间的详细信息
     * @return
     */
    @Select("select * from ")
    List<LiveRecording> getLive();

//    @Results(value = {
//            @Result(property = "liveId",column = "live_id",
//            one = @One(select = "top.durandal.dao.LiveDao.getLiveId"))
//    })

    /**
     * 通过直播间号获得记录
     * @param liveId
     * @return
     */
    @Select("select * from live_recording where live_id = #{liveId}")
    List<LiveRecording> getLiveRecordingByUserId(String liveId);
}