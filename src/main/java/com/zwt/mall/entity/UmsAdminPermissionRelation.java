package com.zwt.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表实体类
 *
 * @author zhouwt
 * @since 2021-08-17 16:38:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsAdminPermissionRelation extends Model<UmsAdminPermissionRelation> implements Serializable {
    private static final long serialVersionUID = 836500997202497390L;

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("$column.comment")
    private Long adminId;

    @ApiModelProperty("$column.comment")
    private Long permissionId;

    @ApiModelProperty("$column.comment")
    private Integer type;
}
