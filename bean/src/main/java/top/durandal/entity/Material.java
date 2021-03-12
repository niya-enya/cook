package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Material)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material implements Serializable {
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 作品ID
     */
    private Integer worksId;
    /**
     * 原料名称
     */
    private String materialName;
    /**
     * 用料配比
     */
    private String materialCount;

}