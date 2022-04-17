package com.example.demo.entity.post;

import com.example.demo.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

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

    @Column(name = "author_avatar")
    private String authorAvatar;
    @Column(name ="image_id")
    private Long imageId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "group_id")
    private Long groupId;
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
    @Column(name = "library_id")
    private Long libraryId;


    public Long getId() {
        return id;
    }




    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
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

    public Long getUserId() {
        return user.getId();
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
