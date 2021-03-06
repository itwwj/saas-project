package com.gitee.saas.common.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 基础实体
 *
 * @author jie
 * @date 2019/05/05
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Entity<T> extends SuperEntity<T> {

    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER = "updateUser";
    private static final long serialVersionUID = 5169873634279173683L;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected T updateUser;

    public Entity(T id, LocalDateTime createTime, T createUser, LocalDateTime updateTime, T updateUser) {
        super(id, createTime, createUser);
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
}
