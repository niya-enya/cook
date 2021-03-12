package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Categories)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories implements Serializable {
    /**
     * 商品分类ID
     */
    private Integer categoriesId;
    /**
     * 商品分类名称
     */
    private String categoriesName;
    /**
     * 商品上级ID
     */
//    private int categoriesMaster;

    private Categories categoriesMaster;
}