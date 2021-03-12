package top.durandal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    /**
     * 评论ID
     */
    @ApiModelProperty(hidden = true)
    private Integer worksId;
    @ApiModelProperty(hidden = true)
    private Works worksMsg;
    /**
     * 发布内容
     */
    @ApiModelProperty(hidden = true)
    private String commentContent;
    /**
     * 评论日期
     */
    @ApiModelProperty(hidden = true)
    private String commentDate;

    @ApiModelProperty(hidden = true)
    private Integer userFromId;
    @ApiModelProperty(hidden = true)
    private User userFromMsg;

    @ApiModelProperty(hidden = true)
    private Integer userToId;
}