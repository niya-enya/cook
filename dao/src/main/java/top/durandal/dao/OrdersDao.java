package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Orders;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:37
 */
@Mapper
@Repository
public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ordersId 主键
     * @return 实例对象
     */
    Orders queryById(Integer ordersId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    @Insert("insert into orders (user_id,address_id,orders_number,orders_total)")
    int insert(Orders orders);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orders> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Orders> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orders> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Orders> entities);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param ordersId 主键
     * @return 影响行数
     */
    int deleteById(Integer ordersId);

    @Select("select * from orders where user_id = #{userId}")
    @Results(value = {
            @Result(property = "address",column = "address_id",
                    one = @One(select = "top.durandal.dao.AddressDao.queryById"))
    })
    List<Orders> getAllOrdersByUserId(Integer userId);
}