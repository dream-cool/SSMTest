package com.pojo;

import java.util.List;

public class Blog {
    private  Integer id;
    private String title;
    private  String summary;
    private  Integer u_id;
    private String content;
    private List<String> comments;

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private  User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", u_id=" + u_id +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }
}
