package com.zzjcy.feign.mall.service;

import com.zzjcy.feign.mall.controller.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @date 2018/5/31
 */
@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Product loadByItemCode(@PathVariable("itemCode") String itemCode) {
        return new Product("error", "未知", "TwoStepsFromJava-Fallback", 0);
    }
}
