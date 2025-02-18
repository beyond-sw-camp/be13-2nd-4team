package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue
    private Long no;

    @Column(nullable = false)
    private String teamName;

    @Column
    private String teamIntroduce;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Enumerated(EnumType.STRING)
    private TimePeriod timePeriod;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @OneToOne(mappedBy = "team")
    private Project project;
}