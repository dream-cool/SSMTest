package com.clt.controller;


import com.clt.dto.ProductDto;
import com.clt.pojo.Product;
import com.clt.pojo.User;
import com.clt.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/select" )
    @ResponseBody
    public PageInfo<Product> ajax(ProductDto productDto){
//        PageHelper.startPage(productDto.gtePageNum(),15);
        List<Product> productList=productService.select(productDto);
        PageInfo<Product> pageInfo=new PageInfo<>(productList);
        return pageInfo;
    }
}
