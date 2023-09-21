package com.chiiiplow.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.ware.entity.WareOrderTaskDetailEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:23:19
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

