package top.durandal.api.service;


import top.durandal.entity.Categories;

import java.util.List;

/**
 * (Categories)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:54
 */
public interface CategoriesService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoriesId 主键
     * @return 实例对象
     */
    Categories queryById(Integer categoriesId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Categories> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param categories 实例对象
     * @return 实例对象
     */
    Categories insert(Categories categories);

    /**
     * 修改数据
     *
     * @param categories 实例对象
     * @return 实例对象
     */
    Categories update(Categories categories);

    /**
     * 通过主键删除数据
     *
     * @param categoriesId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer categoriesId);

    List<Categories> getAll();
}