package com.zwt.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表实体类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsAdminRoleRelation extends Model<UmsAdminRoleRelation> implements Serializable {
    private static final long serialVersionUID = 735609072607362892L;

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("$column.comment")
    private Long adminId;

    @ApiModelProperty("$column.comment")
    private Long roleId;
}
