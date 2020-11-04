package com.gitee.saas.common.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SuperEntity<T> implements Serializable {
    public static final String FIELD_ID = "id";
    public static final String CREATE_TIME = "createTime";
    public static final String CREATE_TIME_COLUMN = "create_time";
    public static final String CREATE_USER = "createUser";
    public static final String CREATE_USER_COLUMN = "create_user";

    private static final long serialVersionUID = -4603650115461757622L;

    @TableId(value = "id", type = IdType.INPUT)
    @NotNull(message = "id不能为空")
    protected T id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected T createUser;


}
