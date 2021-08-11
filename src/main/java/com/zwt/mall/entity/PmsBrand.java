package com.zwt.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 品牌表(PmsBrand)表实体类
 *
 * @author liuyzh
 * @since 2021-08-10 16:26:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class PmsBrand extends Model<PmsBrand> implements Serializable {
    private static final long serialVersionUID = 629238960716145434L;

    @ApiModelProperty("品牌故事")
    private String brandStory;

    @ApiModelProperty("专区大图")
    private String bigPic;

    @ApiModelProperty("品牌logo")
    private String logo;

    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;

    @ApiModelProperty("产品数量")
    private Integer productCount;

    @ApiModelProperty("$column.comment")
    private Integer showStatus;

    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @ApiModelProperty("$column.comment")
    private Integer sort;

    @ApiModelProperty("首字母")
    private String firstLetter;

    @ApiModelProperty("$column.comment")
    private String name;

    @ApiModelProperty("$column.comment")
    private Long id;
}
