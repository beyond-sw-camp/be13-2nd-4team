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
    
    // [홍재민] 25-02-20 팀-유저 중간테이블 cascade 설정
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamUser> teamUsers = new ArrayList<>();

    // @OneToOne(mappedBy = "team")
    // private Project project;

    public void updateTeamDetails(String teamName, String teamIntroduce, ProjectStatus projectStatus, TimePeriod timePeriod) {
        this.teamName = teamName;
        this.teamIntroduce = teamIntroduce;
        this.projectStatus = projectStatus;
        this.timePeriod = timePeriod;
    }
}