package com.fubaofei.feign.mall.service;

import com.fubaofei.feign.mall.controller.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @date 2018/5/31
 */
@FeignClient(name = "PRODUCT-SERVICE", fallback = ProductServiceFallBack.class)
public interface ProductService  {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> findAll();

    @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
    Product loadByItemCode(@PathVariable("itemCode") String itemCode);
}
