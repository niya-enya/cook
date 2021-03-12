package top.durandal.api.service;

import top.durandal.entity.Live;

import java.util.List;

/**
 * (Live)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:58
 */
public interface LiveService {

    /**
     * 通过ID查询单条数据
     *
     * @param liveId 主键
     * @return 实例对象
     */
    Live queryById(String liveId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Live> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param live 实例对象
     * @return 实例对象
     */
    Live insert(Live live);

    /**
     * 修改数据
     *
     * @param live 实例对象
     * @return 实例对象
     */
    Live update(Live live);

    /**
     * 通过主键删除数据
     *
     * @param liveId 主键
     * @return 是否成功
     */
    boolean deleteById(String liveId);

    /**
     * 通过人气获取前四的直播间信息
     * @return 这些直播间的信息数据
     */
    List<Live> getLiveByHeat();

    /**
     * 获得所有的直播间
     * @return
     */
    List<Live> getLive();

    Live insertLive(Live live);
}