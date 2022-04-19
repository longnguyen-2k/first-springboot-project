package com.example.demo.entity.post;

import com.example.demo.entity.group.Group;
import com.example.demo.entity.libraryImage.ImageEntity;
import com.example.demo.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "posts")
public class Post implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post")
    private List<ImageEntity> images;
    @ManyToOne
    private Group group;
    @Column(name = "blocked")
    private Boolean blocked;
    @Column(name = "expired")
    private Long expired;
    @Column(name = "hide_name")
    private Boolean hideName;
    @Column(name = "coins")
    private Long coins;
    @Column(name = "is_fee")
    private Boolean isFee;
    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }


    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }


    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    public Boolean getHideName() {
        return hideName;
    }

    public void setHideName(Boolean hideName) {
        this.hideName = hideName;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public Boolean getFee() {
        return isFee;
    }

    public void setFee(Boolean fee) {
        isFee = fee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return user.getId();
    }

    public Map<String,String> getOwnerInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("userName",user.getUserName());
        map.put("userAvatar",user.getAvatar());
        return map;
    }
    public Long getGroupId() {
        return group.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
