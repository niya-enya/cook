package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    /**
     * 文章步骤
     */
    private Integer articleStep;
    /**
     * 作品ID
     */
    private Integer worksId;
    /**
     * 文章图片
     */
    private String articleImg;
    /**
     * 文章内容
     */
    private String articleContent;
}