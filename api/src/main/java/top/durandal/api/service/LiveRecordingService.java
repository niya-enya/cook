package top.durandal.api.service;


import top.durandal.entity.Live;
import top.durandal.entity.LiveRecording;

import java.util.List;

/**
 * (LiveRecording)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:59
 */
public interface LiveRecordingService {

    /**
     * 通过ID查询单条数据
     *
     * @param liveRecordingId 主键
     * @return 实例对象
     */
    LiveRecording queryById(Integer liveRecordingId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<LiveRecording> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param liveRecording 实例对象
     * @return 实例对象
     */
    LiveRecording insert(LiveRecording liveRecording);

    /**
     * 修改数据
     *
     * @param liveRecording 实例对象
     * @return 实例对象
     */
    LiveRecording update(LiveRecording liveRecording);

    /**
     * 通过主键删除数据
     *
     * @param liveRecordingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer liveRecordingId);


    List<LiveRecording> getLiveRecordingByUserId(Integer userId);
}