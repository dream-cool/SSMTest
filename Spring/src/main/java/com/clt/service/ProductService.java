package com.clt.service;

import com.clt.dto.ProductDto;
import com.clt.pojo.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    List<Product> select(ProductDto productDto);

    List<Product> selectAll();
}
