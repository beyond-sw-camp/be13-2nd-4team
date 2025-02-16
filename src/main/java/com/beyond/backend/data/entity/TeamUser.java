package com.beyond.backend.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_user")
public class TeamUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private char status; // F (EnumType 고려)

    @Column
    private String role;

    @Embedded
    private TimePeriod timePeriod;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_no", nullable = false)
    private Team team;

}
