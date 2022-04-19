package com.example.demo.entity.group;

import com.example.demo.entity.libraryImage.ImageType;
import com.example.demo.entity.post.Post;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "group_posts")
public class Group  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    private SubjectEntity subject;
    @Column(name = "image_id")
    private Long avatar;
    @Column(name = "blocked")
    private Boolean blocked;
    @Column(name = "is_private")
    private Boolean isPrivate;

    @OneToMany(mappedBy = "group")
    private List<Post> posts;
    public Group() {
    }

    public Group(Long id, String groupName, Long avatar, Boolean blocked, Boolean isPrivate) {
        this.id = id;
        this.groupName = groupName;
        this.avatar = avatar;
        this.blocked = blocked;
        this.isPrivate = isPrivate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
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
