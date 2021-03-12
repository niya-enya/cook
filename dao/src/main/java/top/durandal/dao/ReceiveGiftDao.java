package top.durandal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.durandal.entity.ReceiveGift;

import java.util.List;

/**
 * (ReceiveGift)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:37
 */
@Mapper
@Repository
public interface ReceiveGiftDao {

    /**
     * 通过ID查询单条数据
     *
     * @param receiveGiftId 主键
     * @return 实例对象
     */
    ReceiveGift queryById(Integer receiveGiftId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ReceiveGift> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param receiveGift 实例对象
     * @return 对象列表
     */
    List<ReceiveGift> queryAll(ReceiveGift receiveGift);

    /**
     * 新增数据
     *
     * @param receiveGift 实例对象
     * @return 影响行数
     */
    @Insert("insert into receive_gift (live_id,user_id,gift_id,gift_name) values(#{liveId},#{userId},#{giftId},#{giftName})")
    void insert(ReceiveGift receiveGift);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ReceiveGift> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ReceiveGift> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ReceiveGift> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ReceiveGift> entities);

    /**
     * 修改数据
     *
     * @param receiveGift 实例对象
     * @return 影响行数
     */
    int update(ReceiveGift receiveGift);

    /**
     * 通过主键删除数据
     *
     * @param receiveGiftId 主键
     * @return 影响行数
     */
    int deleteById(Integer receiveGiftId);

}