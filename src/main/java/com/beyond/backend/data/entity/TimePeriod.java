package com.beyond.backend.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimePeriod {

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일

    @Column(nullable = true)
    private LocalDateTime updatedAt; // 최근 업데이트

    // 홍재민 25-02-19 [시간 자동 설정 추가]
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}