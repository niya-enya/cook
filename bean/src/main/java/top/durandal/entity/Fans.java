package top.durandal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Fans)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fans implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(hidden = true)
    private Integer userId;
    private User user;
    /**
     * 粉丝ID
     */
    @ApiModelProperty(hidden = true)
    private Integer fansId;
    private User fans;
}