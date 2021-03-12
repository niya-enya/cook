package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Sort;

import java.util.List;

/**
 * (Sort)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:39
 */
@Mapper
@Repository
public interface SortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sortId 主键
     * @return 实例对象
     */
    Sort queryById(Integer sortId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select * from sort")
    List<Sort> queryAll();

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int insert(Sort sort);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sort> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sort> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sort> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Sort> entities);

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int update(Sort sort);

    /**
     * 通过主键删除数据
     *
     * @param sortId 主键
     * @return 影响行数
     */
    int deleteById(Integer sortId);

}