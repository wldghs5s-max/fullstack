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
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    @Column(length = 1,nullable = false)
    private String delYn;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        delYn = "N";
    }
    @PreUpdate
    public void preUpdate(){
        modifiedAt = LocalDateTime.now();
    }
}
