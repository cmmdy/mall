package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsAdminRoleRelationMapper;
import com.zwt.mall.entity.UmsAdminRoleRelation;
import com.zwt.mall.service.UmsAdminRoleRelationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:06
 */
@Service
@Slf4j
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements UmsAdminRoleRelationService {

    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
}
