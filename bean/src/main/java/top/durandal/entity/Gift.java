package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Gift)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift implements Serializable {
    /**
     * 礼物编号ID
     */
    private Integer giftId;
    /**
     * 礼物名称
     */
    private String giftName;
    /**
     * 礼物价格
     */
    private Integer giftPrice;
}