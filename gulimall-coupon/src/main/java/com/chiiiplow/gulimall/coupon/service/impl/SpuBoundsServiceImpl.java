package com.chiiiplow.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.gulimall.coupon.dao.SpuBoundsDao;
import com.chiiiplow.gulimall.coupon.entity.SpuBoundsEntity;
import com.chiiiplow.gulimall.coupon.service.SpuBoundsService;
import com.chiiiplow.common.utils.PageUtils;
import com.chiiiplow.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("spuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsDao, SpuBoundsEntity> implements SpuBoundsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuBoundsEntity> page = this.page(
                new Query<SpuBoundsEntity>().getPage(params),
                new QueryWrapper<SpuBoundsEntity>()
        );

        return new PageUtils(page);
    }

}