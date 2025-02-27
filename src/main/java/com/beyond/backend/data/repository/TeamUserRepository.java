package com.beyond.backend.data.repository;

import java.util.List;

import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.TeamUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p> 팀 유저 리포지토리
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : TeamUserRepository
 * <p>author         : hongjm
 * <p>date           : 2025-02-20
 * <p>description    : 팀 유저 중간 테이블 리포지토리
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-20        hongjm           최초 생성
 */

public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {

    @Query("SELECT new com.beyond.backend.data.dto.TeamSearchDto(t.teamName, t.teamIntroduce, t.projectStatus) " +
            "FROM User u " +
            "JOIN TeamUser tu ON u.no = tu.user.no " +
            "JOIN Team t ON tu.team.no = t.no " +
            "WHERE u.no = :userNo")
    Page<TeamSearchDto> findUserTeams(@Param("userNo") Long userNo, Pageable pageable);

    // [홍도현] userNo가 teamNo에 속해 있는지 확인 (존재하면 true, 없으면 false 반환)
    boolean existsByUserNoAndTeamNo(Long userNo, Long teamNo);

}
