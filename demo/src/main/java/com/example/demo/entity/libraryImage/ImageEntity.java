package com.example.demo.entity.libraryImage;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name =  "images")
public class ImageEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image_type",columnDefinition = "enum('ADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @Column(name = "parent_id")
    private Long parentId;

    public ImageEntity(ImageType imageType, Long parentId) {
        this.imageType = imageType;
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public ImageEntity() {
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
