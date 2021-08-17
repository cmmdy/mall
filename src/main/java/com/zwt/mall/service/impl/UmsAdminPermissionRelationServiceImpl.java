package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsAdminPermissionRelationMapper;
import com.zwt.mall.entity.UmsAdminPermissionRelation;
import com.zwt.mall.service.UmsAdminPermissionRelationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:38:34
 */
@Service
@Slf4j
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper,
        UmsAdminPermissionRelation> implements UmsAdminPermissionRelationService {

    @Autowired
    private UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;
}
