package top.durandal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Works)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Works implements Serializable {
    /**
     * 作品ID
     */
    @ApiModelProperty(hidden = true)
    private Integer worksId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 分类编号ID
     */
    private Integer sortId;
    /**
     * 作者
     */
    private String worksAuthor;
    /**
     * 发布时间
     */
    private Date worksTime;
    /**
     * 作品标题
     */
    private String worksTitle;
    /**
     * 作品封面
     */
    private Object worksCover;
    /**
     * 作品是否能够显示
     */
    private String worksShow;

    private String worksType;

    private String worksDescribe;

}