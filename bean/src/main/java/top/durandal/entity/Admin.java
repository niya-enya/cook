package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    /**
     * 管理员ID
     */
    private Integer adminId;
    /**
     * 角色编号
     */
    private Integer roleId;
    /**
     * 用户名
     */
    private String adminName;
    /**
     * 密码
     */
    private String adminPass;
    /**
     * 直接上级编号
     */
    private Integer adminNum;

}