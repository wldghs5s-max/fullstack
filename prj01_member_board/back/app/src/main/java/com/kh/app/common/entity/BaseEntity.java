package com.kh.app.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Column(length = 1,nullable = false)
    protected String delYn;
    @Column(nullable = false,updatable = false)
    protected LocalDateTime createdAt;
    protected LocalDateTime modifiedAt;

    @PrePersist
    public void prePersist(){
        this.delYn = "N";
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.modifiedAt = LocalDateTime.now();
    }
}
