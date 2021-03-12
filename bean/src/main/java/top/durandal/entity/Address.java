package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    /**
     * 地址ID
     */
    private Integer addressId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 省
     */
    private Object addressProvince;
    /**
     * 市
     */
    private String addressCity;
    /**
     * 区/县
     */
    private String addressDistrict;
    /**
     * 详细地址
     */
    private String addressAddress;

    private Integer addressPostcode;

    private String  addressNumber;
}