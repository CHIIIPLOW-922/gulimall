package com.chiiiplow.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.coupon.entity.HomeAdvEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 13:55:18
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

