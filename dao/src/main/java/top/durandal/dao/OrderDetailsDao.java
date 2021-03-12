package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.durandal.entity.OrderDetails;

import java.util.List;

/**
 * (OrderDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:36
 */
@Mapper
@Repository
public interface OrderDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ordersId
     * @return 实例对象
     */
    @Select("select * from orderDetails where order_id = #{ordersId}")
    OrderDetails queryByOrdersId(Integer ordersId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderDetails 实例对象
     * @return 对象列表
     */
    List<OrderDetails> queryAll(OrderDetails orderDetails);

    /**
     * 新增数据
     *
     * @param orderDetails 实例对象
     * @return 影响行数
     */
    int insert(OrderDetails orderDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderDetails> entities);

    /**
     * 修改数据
     *
     * @param orderDetails 实例对象
     * @return 影响行数
     */
    int update(OrderDetails orderDetails);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById();

}