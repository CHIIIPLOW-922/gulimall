package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.common.utils.PageUtils;
import com.chiiiplow.gulimall.product.entity.SkuInfoEntity;
import com.chiiiplow.gulimall.product.vo.SkuItemVo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author CHIIIPLOW
 * @email q641484973@gmail.com
 * @date 2020-05-22 19:00:18
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}

