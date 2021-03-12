package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Sort)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sort implements Serializable {
    /**
     * 分类编号ID
     */
    private Integer sortId;
    /**
     * 分类名
     */
    private String sortName;

}