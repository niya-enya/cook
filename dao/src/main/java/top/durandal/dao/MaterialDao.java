package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Material;

import java.util.List;

/**
 * (Material)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:36
 */
@Mapper
@Repository
public interface MaterialDao {

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    Material queryById(Integer materialId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Material> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param material 实例对象
     * @return 对象列表
     */
    List<Material> queryAll(Material material);

    /**
     * 新增数据
     *
     * @param material 实例对象
     * @return 影响行数
     */
    int insert(Material material);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Material> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Material> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Material> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Material> entities);

    /**
     * 修改数据
     *
     * @param material 实例对象
     * @return 影响行数
     */
    int update(Material material);

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 影响行数
     */
    int deleteById(Integer materialId);

    /**
     * 通过作品ID获得所有该id下的食材
     * @param worksId
     * @return
     */
    @Select("select * from material where works_id = #{worksId}")
    List<Material> getMaterialByWorksId(int worksId);
}