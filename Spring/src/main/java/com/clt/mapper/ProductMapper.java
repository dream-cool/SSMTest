package com.clt.mapper;

import com.clt.dto.ProductDto;
import com.clt.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> select(ProductDto productDto);

    List<Product> selectAll();
}
