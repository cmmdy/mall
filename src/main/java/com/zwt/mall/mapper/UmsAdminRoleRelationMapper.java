package com.zwt.mall.mapper;

import com.zwt.mall.entity.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwt.mall.entity.UmsPermission;

import java.util.List;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表数据库访问层
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:06
 */
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {

    List<UmsPermission> getPermissionListById(Long id);
}
