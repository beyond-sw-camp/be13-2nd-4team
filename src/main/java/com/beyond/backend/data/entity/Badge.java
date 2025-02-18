package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String description; // 뱃지 설명

    @OneToMany(mappedBy = "badge", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserBadge> userBadges = new HashSet<>();


}
