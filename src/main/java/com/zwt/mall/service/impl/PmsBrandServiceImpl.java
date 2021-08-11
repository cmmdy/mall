package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.PmsBrandMapper;
import com.zwt.mall.entity.PmsBrand;
import com.zwt.mall.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 品牌表(PmsBrand)表服务实现类
 *
 * @author liuyzh
 * @since 2021-08-10 16:37:33
 */
@Service
@Slf4j
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;
}
