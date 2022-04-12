package com.example.demo.entity.group;

import com.example.demo.entity.libraryImage.ImageType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groups")
public class Group  implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String group_name;

    private String subject_id;
    @Column(name = "image_id")
    private Long avatar;
    @Column(name = "blocked")
    private Boolean blocked;
    @Column(name = "is_private")
    private Boolean isPrivate;

    public Group() {
    }

    public Group(Long id, String group_name, String subject_id, Long avatar, Boolean blocked, Boolean isPrivate) {
        this.id = id;
        this.group_name = group_name;
        this.subject_id = subject_id;
        this.avatar = avatar;
        this.blocked = blocked;
        this.isPrivate = isPrivate;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public Long getAvatar() {
        return avatar;
    }

    public void setAvatar(Long avatar) {
        this.avatar = avatar;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
