package com.chiiiplow.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.order.entity.OrderOperateHistoryEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:19:20
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

