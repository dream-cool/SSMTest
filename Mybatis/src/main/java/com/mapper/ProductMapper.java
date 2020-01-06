package com.mapper;



import com.pojo.Product;
import com.pojo.dto.ProductDto;

import java.util.List;

public interface ProductMapper {
    List<Product> select(ProductDto productDto);
}
