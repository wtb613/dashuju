package com.offcn.service.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> selectProductAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> selectHotProductAll() {
        return productDao.selectHotAll();
    }

    @Override
    public List<Product> selectYouxuanProductAll() {
        return productDao.selectYouxuanAll();
    }

    @Override
    public Product selectById(String productId) {
        return productDao.productById(productId);
    }
}
