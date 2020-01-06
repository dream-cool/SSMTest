package com.clt.service.impl;


import com.clt.dto.ProductDto;
import com.clt.mapper.ProductMapper;
import com.clt.pojo.Product;
import com.clt.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> select(ProductDto productDto) {
        return productMapper.select(productDto);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

}
