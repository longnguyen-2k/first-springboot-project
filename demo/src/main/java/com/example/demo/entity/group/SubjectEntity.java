package com.example.demo.entity.group;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subjects")
public class SubjectEntity   implements Serializable {

    public SubjectEntity() {
    }

    public SubjectEntity(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "name_subject")
    private String nameSubject;


    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }
}
