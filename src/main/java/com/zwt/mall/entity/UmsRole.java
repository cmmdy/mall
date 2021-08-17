package com.zwt.mall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台用户角色表(UmsRole)表实体类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsRole extends Model<UmsRole> implements Serializable {
    private static final long serialVersionUID = 502334543815484516L;

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("后台用户数量")
    private Integer adminCount;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty("$column.comment")
    private Integer sort;
}
