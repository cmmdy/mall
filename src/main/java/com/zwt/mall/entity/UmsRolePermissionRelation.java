package com.zwt.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表实体类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsRolePermissionRelation extends Model<UmsRolePermissionRelation> implements Serializable {
    private static final long serialVersionUID = -74163598153955515L;

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("$column.comment")
    private Long roleId;

    @ApiModelProperty("$column.comment")
    private Long permissionId;
}
