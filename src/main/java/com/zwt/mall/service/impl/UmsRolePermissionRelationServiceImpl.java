package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsRolePermissionRelationMapper;
import com.zwt.mall.entity.UmsRolePermissionRelation;
import com.zwt.mall.service.UmsRolePermissionRelationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:21
 */
@Service
@Slf4j
public class UmsRolePermissionRelationServiceImpl extends ServiceImpl<UmsRolePermissionRelationMapper,
        UmsRolePermissionRelation> implements UmsRolePermissionRelationService {

    @Autowired
    private UmsRolePermissionRelationMapper umsRolePermissionRelationMapper;
}
