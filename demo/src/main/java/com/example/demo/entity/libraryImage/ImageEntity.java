package com.example.demo.entity.libraryImage;

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

    @JoinColumn(name = "image_type_id")
    @ManyToOne
    private ImageTypeEntity imageTypeEntity;

    public ImageEntity(ImageTypeEntity imageTypeEntities) {
        this.imageTypeEntity = imageTypeEntities;
    }

    public ImageTypeEntity getImageTypeEntities() {
        return imageTypeEntity;
    }

    public void setImageTypeEntities(ImageTypeEntity imageTypeEntity) {
        this.imageTypeEntity = imageTypeEntity;
    }

    public ImageEntity() {
    }
}
