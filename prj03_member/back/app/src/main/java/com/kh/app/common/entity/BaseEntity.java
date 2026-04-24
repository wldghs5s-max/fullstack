package com.kh.app.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Column(nullable = false,length = 1)
    private String delYn;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @PrePersist
    public void prePersist(){
        delYn = "N";
        createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        modifiedAt = LocalDateTime.now();
    }

    public void delete() {
        delYn = "Y";
    }
}
