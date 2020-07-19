package com.offcn.dao;

import com.offcn.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    List<Product> selectAll();
    List<Product> selectHotAll();
    List<Product> selectYouxuanAll();

    Product productById(String productId);
}
