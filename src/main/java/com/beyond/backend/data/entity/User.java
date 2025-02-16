package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id")})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_no")
    private Long no;

    @Column(nullable = false, length = 50)
    private String userId; //아이디

    @Column(nullable = false)
    private String name; //성명

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    private String phoneNum;

    private String address;

    //Status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; //ACTIVE, INACTIVE, DELETED

    private String email;

    @Embedded
    private TimePeriod timePeriod;

    //========================================================================

    //유저 뱃지와 1:N 관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserBadge> userBadges = new ArrayList<>();

    // 보낸 쪽지 리스트 (1:N 관계)
    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages = new ArrayList<>();

    // 받은 쪽지 리스트 (1:N 관계)
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    // [홍재민] 팀 구성과 연결
    @OneToMany(mappedBy = "user")
    private List<TeamUser> teamUsers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookMark> bookmarks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserTech> userTeches;
}