package com.example.demo.entity.libraryImage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "image_types")
public class ImageTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_type",columnDefinition = "enum('POST','GROUP','USER')")
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @OneToMany
    private List<ImageEntity> listImageEntity;

    public ImageTypeEntity() {
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public ImageTypeEntity(ImageType imageType) {
        this.imageType = imageType;
    }

    public Long getId() {
        return id;
    }

    public ImageType getImageType() {
        return imageType;
    }
}
