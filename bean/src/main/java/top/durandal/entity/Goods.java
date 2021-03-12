package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 分类ID
     */
    private Integer categoriesId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 库存
     */
    private Integer goodsStock;
    /**
     * 商品简介
     */
    private String goodsIntroduction;
    /**
     * 商品价格
     */
    private Double goodsPrice;
    /**
     * 商品图片
     */
    private String goodsImg;

}