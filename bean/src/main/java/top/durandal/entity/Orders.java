package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 订单ID
     */
    private Integer ordersId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 订单号
     */
    private String ordersNumber;
    /**
     * 总价
     */
    private String ordersTotal;

    private Object address;

}