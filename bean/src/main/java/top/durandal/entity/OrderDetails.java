package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (OrderDetails)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements Serializable {
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 选择个数
     */
    private Integer goodsNum;

}