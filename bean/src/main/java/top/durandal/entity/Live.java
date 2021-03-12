package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Live)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Live implements Serializable {
    /**
     * 直播间编号
     */
    private String liveId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 直播间封面
     */
    private String liveImg;
    /**
     * 直播间标题
     */
    private String liveTitle;

    private String liveState;

    private Integer liveNumber;

}