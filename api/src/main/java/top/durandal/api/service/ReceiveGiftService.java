package top.durandal.api.service;


import top.durandal.entity.ReceiveGift;

import java.util.List;

/**
 * (ReceiveGift)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:50:02
 */
public interface ReceiveGiftService {

    /**
     * 通过ID查询单条数据
     *
     * @param receiveGiftId 主键
     * @return 实例对象
     */
    ReceiveGift queryById(Integer receiveGiftId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ReceiveGift> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param receiveGift 实例对象
     * @return 实例对象
     */
    ReceiveGift insert(ReceiveGift receiveGift);

    /**
     * 修改数据
     *
     * @param receiveGift 实例对象
     * @return 实例对象
     */
    ReceiveGift update(ReceiveGift receiveGift);

    /**
     * 通过主键删除数据
     *
     * @param receiveGiftId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer receiveGiftId);

}