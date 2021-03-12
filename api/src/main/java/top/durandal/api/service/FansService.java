package top.durandal.api.service;


import top.durandal.entity.Fans;
import top.durandal.entity.User;

import java.util.List;

/**
 * (Fans)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:56
 */
public interface FansService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Fans queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Fans> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param fans 实例对象
     * @return 实例对象
     */
    Fans insert(Fans fans);

    /**
     * 修改数据
     *
     * @param fans 实例对象
     * @return 实例对象
     */
    Fans update(Fans fans);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteById();

    Boolean getFans(Integer userId,Integer followId);

    List<Fans> getAllFans(Integer userId);

    List<Fans> getAllFollow(Integer userId);
}