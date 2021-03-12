package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Categories;

import java.util.List;

/**
 * (Categories)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:30
 */
@Mapper
@Repository
public interface CategoriesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoriesId 主键
     * @return 实例对象
     */
    @Select("select * from categories where categories_id = #{categoriesId}")
    @Results({
            @Result(property = "categoriesMaster" ,column = "categories_master",
            one = @One(select = "top.durandal.dao.CategoriesDao.queryById"))
    })
    Categories queryById(Integer categoriesId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Categories> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param categories 实例对象
     * @return 对象列表
     */
    List<Categories> queryAll(Categories categories);

    /**
     * 新增数据
     *
     * @param categories 实例对象
     * @return 影响行数
     */
    int insert(Categories categories);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Categories> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Categories> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Categories> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Categories> entities);

    /**
     * 修改数据
     *
     * @param categories 实例对象
     * @return 影响行数
     */
    int update(Categories categories);

    /**
     * 通过主键删除数据
     *
     * @param categoriesId 主键
     * @return 影响行数
     */
    int deleteById(Integer categoriesId);

    @Select("select * from categories")
    @Results({
            @Result(property = "categoriesMaster" ,column = "categories_master",
                    one = @One(select = "top.durandal.dao.CategoriesDao.queryById"))
    })
    List<Categories> getAll();
}