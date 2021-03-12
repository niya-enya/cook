package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {
    /**
     * 操作记录ID
     */
    private Integer logId;
    /**
     * 管理员ID
     */
    private Integer adminId;
    /**
     * 操作时间
     */
    private Object logDate;
    /**
     * 操作事务
     */
    private String logAffair;

}