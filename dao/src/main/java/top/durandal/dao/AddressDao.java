package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Address;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 20:30:22
 */
@Mapper
@Repository
public interface AddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Select("select * from address where address_id = #{addressId}")
    Address queryById(Integer addressId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param address 实例对象
     * @return 对象列表
     */
    List<Address> queryAll(Address address);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    @Insert("insert into address (user_id,address_province,address_city,address_district,address_address,address_postcode,address_number " +
            "values(#{userId},#{addressProvince},#{addressCity},#{addressDistrict},#{addressAddress},#{addressPostcode},#{addressNumber})")
    @Options(useGeneratedKeys = true,keyProperty = "addressId")
    int insert(Address address);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Address> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Address> entities);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 影响行数
     */
    int deleteById(Integer addressId);

    /**
     * 通过用户id获得所有地址信息
     * @param userId
     * @return
     */
    @Select("select * from address where user_id = #{userId}")
    List<Address> getAddressByUserId(Integer userId);
}