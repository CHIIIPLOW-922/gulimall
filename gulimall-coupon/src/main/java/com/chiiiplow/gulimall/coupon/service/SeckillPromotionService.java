package com.chiiiplow.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.coupon.entity.SeckillPromotionEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 13:55:18
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

