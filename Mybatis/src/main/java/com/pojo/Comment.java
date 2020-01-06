package com.pojo;

public class Comment {
    private  Integer id;
    private  String content;
    private  Integer b_id;

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", b_id=" + b_id +
                '}';
    }
}
