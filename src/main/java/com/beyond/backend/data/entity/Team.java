package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
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

    @OneToMany(mappedBy = "team")
    private List<TeamUser> teamUsers = new ArrayList<>();

    @OneToOne(mappedBy = "team")
    private Project project;

}