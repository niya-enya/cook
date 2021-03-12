package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ReceiveGift)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveGift implements Serializable {
    /**
     * 这张表的ID，有无都行
     */
    private Integer receiveGiftId;
    /**
     * 直播间编号
     */
    private String liveId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 礼物编号ID
     */
    private Integer giftId;
    /**
     * 礼物名称
     */
    private String giftName;

}