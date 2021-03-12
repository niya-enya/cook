package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Shoppingcar;

import java.util.List;

/**
 * (Shoppingcar)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:39
 */
@Mapper
@Repository
public interface ShoppingcarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingcarId 主键
     * @return 实例对象
     */
    @Select("select * from shoppingcar where shopping_id=#{shoppingcarId}")
    Shoppingcar queryById(Integer shoppingcarId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Shoppingcar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shoppingcar 实例对象
     * @return 对象列表
     */
    List<Shoppingcar> queryAll(Shoppingcar shoppingcar);

    /**
     * 新增数据
     *
     * @param shoppingcar 实例对象
     * @return 影响行数
     */
    @Insert("insert into shoppingcar (user_id,goods_id,shop_num) values(#{userId},#{goodsId},#{shopNum})")
    @Options(useGeneratedKeys = true,keyProperty = "shoppingcarId")
    int insert(Shoppingcar shoppingcar);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoppingcar> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shoppingcar> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoppingcar> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Shoppingcar> entities);

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 影响行数
     */
    int update(Shoppingcar shoppingcar);

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarId 主键
     * @return 影响行数
     */
    int deleteById(Integer shoppingcarId);

    @Select("select * from shoppingcar where user_id=#{userId}")
    @Results({
            @Result(property = "goods",column = "goods_id",
            one = @One(select = "top.durandal.dao.GoodsDao.queryById"))
    })
    List<Shoppingcar> getAllCartByUserId(Integer userId);
}