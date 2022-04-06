package com.example.demo.models.post;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    public Post() {
    }

    public Post( String title, String content, Long user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "post_sequence"
    )

    private Long id;
    private String title;
    private String content;
    private Long user_id;

    public Long getId() {
        return id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
