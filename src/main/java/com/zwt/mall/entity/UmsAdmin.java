package com.zwt.mall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 后台用户表(UmsAdmin)表实体类
 *
 * @author zhouwt
 * @since 2021-08-17 16:36:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsAdmin extends Model<UmsAdmin> implements Serializable {
    private static final long serialVersionUID = -69645867425834931L;

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("$column.comment")
    @NotNull(message = "不能为空")
    private String username;

    @ApiModelProperty("$column.comment")
    @NotNull(message = "不能为空")
    private String password;

    @ApiModelProperty("头像")
    private String icon;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    private String note;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("最后登录时间")
    private Date loginTime;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;
}
