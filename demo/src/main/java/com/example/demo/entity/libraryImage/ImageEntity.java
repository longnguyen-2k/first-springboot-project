package com.example.demo.entity.libraryImage;

import com.example.demo.entity.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name =  "images")
public class ImageEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Post post;

    @JsonIgnore
    @JoinColumn(name = "image_type_id")
    @ManyToOne
    private ImageTypeEntity imageTypeEntity;

    @Column(name = "image_url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageTypeEntities(ImageTypeEntity imageTypeEntity) {
        this.imageTypeEntity = imageTypeEntity;
    }

    public ImageEntity() {
    }
}
