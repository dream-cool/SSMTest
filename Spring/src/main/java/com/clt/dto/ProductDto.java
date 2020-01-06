package com.clt.dto;

public class ProductDto {

    private String  productname;
    private String  categoryno;
    private String  category;
    private String  size;
    private String  price;
    private String  color;
    private String  saletime;
    private String  salecount;
    private String countorder;
    private String priceorder;
    private String context;
    private int pageNum;

    public ProductDto() {
    }

    public ProductDto(String productname, String categoryno, String category, String size,
                      String price, String color, String saletime, String salecount, String countorder,
                      String priceorder, String context, int pageNum) {
        this.productname = productname;
        this.categoryno = categoryno;
        this.category = category;
        this.size = size;
        this.price = price;
        this.color = color;
        this.saletime = saletime;
        this.salecount = salecount;
        this.countorder = countorder;
        this.priceorder = priceorder;
        this.context = context;
        this.pageNum = pageNum;
    }

    public String getCountorder() {
        return countorder;
    }

    public void setCountorder(String countorder) {
        this.countorder = countorder;
    }

    public String getPriceorder() {
        return priceorder;
    }

    public void setPriceorder(String priceorder) {
        this.priceorder = priceorder;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(String categoryno) {
        this.categoryno = categoryno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSaletime() {
        return saletime;
    }

    public void setSaletime(String saletime) {
        this.saletime = saletime;
    }

    public String getSalecount() {
        return salecount;
    }

    public void setSalecount(String salecount) {
        this.salecount = salecount;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
