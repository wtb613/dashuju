package com.offcn.dao.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jtemplate;

    public JdbcTemplate getJtemplate() {
        return jtemplate;
    }

    public void setJtemplate(JdbcTemplate jtemplate) {
        this.jtemplate = jtemplate;
    }

    @Override
    public List<Product> selectAll() {
        String sql = "select * from Product";
        List<Product> list = jtemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setPro_id(rs.getInt("pro_id"));
                product.setPro_name(rs.getString("pro_name"));
                product.setPro_num(rs.getString("pro_num"));
                product.setMarket_price(rs.getDouble("market_price"));
                product.setShop_price(rs.getDouble("shop_price"));
                product.setPro_total_count(rs.getInt("pro_total_count"));
                product.setPro_max_img(rs.getString("pro_max_img"));
                product.setPro_min_img(rs.getString("pro_min_img"));
                product.setPro_color(rs.getString("pro_color"));
                product.setPro_state(rs.getInt("pro_state"));
                return product;
            }
        });
        return list;
    }

    @Override
    public List<Product> selectHotAll() {
        String sql = "select * from product where pro_state = 1";
        List<Product> list =  jtemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setPro_id(rs.getInt("pro_id"));
                product.setPro_name(rs.getString("pro_name"));
                product.setPro_num(rs.getString("pro_num"));
                product.setMarket_price(rs.getDouble("market_price"));
                product.setShop_price(rs.getDouble("shop_price"));
                product.setPro_total_count(rs.getInt("pro_total_count"));
                product.setPro_max_img(rs.getString("pro_max_img"));
                product.setPro_min_img(rs.getString("pro_min_img"));
                product.setPro_color(rs.getString("pro_color"));
                product.setPro_state(rs.getInt("pro_state"));
                return product;
            }
        });
        return list;
    }

    @Override
    public List<Product> selectYouxuanAll() {
        String sql = "select * from Product where pro_state = 2";
        List<Product> list =  jtemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setPro_id(rs.getInt("pro_id"));
                product.setPro_name(rs.getString("pro_name"));
                product.setPro_num(rs.getString("pro_num"));
                product.setMarket_price(rs.getDouble("market_price"));
                product.setShop_price(rs.getDouble("shop_price"));
                product.setPro_total_count(rs.getInt("pro_total_count"));
                product.setPro_max_img(rs.getString("pro_max_img"));
                product.setPro_min_img(rs.getString("pro_min_img"));
                product.setPro_color(rs.getString("pro_color"));
                product.setPro_state(rs.getInt("pro_state"));
                return product;
            }
        });
        return list;
    }

    @Override
    public Product productById(String productId) {
        String sql = "select * from product where pro_id = ?";
        Product product = new Product();
        jtemplate.query(sql,new Object[]{productId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

                product.setPro_id(rs.getInt("pro_id"));
                product.setPro_name(rs.getString("pro_name"));
                product.setPro_num(rs.getString("pro_num"));
                product.setMarket_price(rs.getDouble("market_price"));
                product.setShop_price(rs.getDouble("shop_price"));
                product.setPro_total_count(rs.getInt("pro_total_count"));
                product.setPro_max_img(rs.getString("pro_max_img"));
                product.setPro_min_img(rs.getString("pro_min_img"));
                product.setPro_color(rs.getString("pro_color"));
                product.setPro_state(rs.getInt("pro_state"));
            }
        });
        return product;
    }
}
