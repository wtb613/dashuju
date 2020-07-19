package com.offcn.service;

import com.offcn.bean.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> selectProductAll();
    List<Product> selectHotProductAll();
    List<Product> selectYouxuanProductAll();

    Product selectById(String productId);
}
