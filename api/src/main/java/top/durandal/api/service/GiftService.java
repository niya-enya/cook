package top.durandal.api.service;


import top.durandal.entity.Gift;

import java.util.List;

/**
 * (Gift)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:57
 */
public interface GiftService {

    /**
     * 通过ID查询单条数据
     *
     * @param giftId 主键
     * @return 实例对象
     */
    Gift queryById(Integer giftId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Gift> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param gift 实例对象
     * @return 实例对象
     */
    Gift insert(Gift gift);

    /**
     * 修改数据
     *
     * @param gift 实例对象
     * @return 实例对象
     */
    Gift update(Gift gift);

    /**
     * 通过主键删除数据
     *
     * @param giftId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer giftId);

}