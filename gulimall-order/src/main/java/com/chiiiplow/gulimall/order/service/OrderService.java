package com.chiiiplow.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.order.entity.OrderEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 订单
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:19:20
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

