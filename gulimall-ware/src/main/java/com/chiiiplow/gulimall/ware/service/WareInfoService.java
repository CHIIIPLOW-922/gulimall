package com.chiiiplow.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.ware.entity.WareInfoEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:23:19
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

