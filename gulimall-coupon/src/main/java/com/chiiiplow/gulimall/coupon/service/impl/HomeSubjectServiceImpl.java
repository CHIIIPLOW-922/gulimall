package com.chiiiplow.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.gulimall.coupon.dao.HomeSubjectDao;
import com.chiiiplow.gulimall.coupon.entity.HomeSubjectEntity;
import com.chiiiplow.gulimall.coupon.service.HomeSubjectService;
import com.chiiiplow.common.utils.PageUtils;
import com.chiiiplow.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("homeSubjectService")
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectDao, HomeSubjectEntity> implements HomeSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeSubjectEntity> page = this.page(
                new Query<HomeSubjectEntity>().getPage(params),
                new QueryWrapper<HomeSubjectEntity>()
        );

        return new PageUtils(page);
    }

}