package com.chiiiplow.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.gulimall.product.dao.SpuInfoDao;
import com.chiiiplow.gulimall.product.entity.SpuInfoEntity;
import com.chiiiplow.gulimall.product.service.SpuInfoService;
import com.chiiiplow.common.utils.PageUtils;
import com.chiiiplow.common.utils.Query;
import com.chiiiplow.gulimall.product.vo.SpuSaveVo;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void savesupInfo(SpuSaveVo vo) {

    }

    @Override
    public void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity) {

    }

    @Override
    public PageUtils queryPageByCondtion(Map<String, Object> params) {
        return null;
    }

    @Override
    public void up(Long spuId) {

    }

    @Override
    public SpuInfoEntity getSpuInfoBySkuId(Long skuId) {
        return null;
    }

}