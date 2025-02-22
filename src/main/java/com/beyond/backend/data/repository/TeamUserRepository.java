package com.beyond.backend.data.repository;

import com.beyond.backend.data.dto.teamDto.TeamMemberListDto;
import com.beyond.backend.data.dto.teamDto.TeamSearchDto;
import com.beyond.backend.data.entity.TeamUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    @Query("SELECT new com.beyond.backend.data.dto.teamDto.TeamSearchDto" +
            "(t.teamName, t.teamIntroduce, t.projectStatus, t.timePeriod) " +
            "FROM User u " +
            "JOIN TeamUser tu ON u.no = tu.user.no " +
            "JOIN Team t ON tu.team.no = t.no " +
            "WHERE u.no = :userNo")
    Page<TeamSearchDto> findUserTeams(@Param("userNo") Long userNo, Pageable pageable);

    /**
     * 해당 팀의 리더 여부 확인
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @return Boolean
     */
    @Query("SELECT tu.isLeader " +
            "FROM TeamUser tu " +
            "JOIN User u ON tu.user.no = u.no " +
            "WHERE tu.team.no = :teamNo AND u.no = :userNo")
    Boolean isLeader(@Param("teamNo") Long teamNo, @Param("userNo") Long userNo);

    /**
     * 해당 팀의 전체 팀원 조회
     * @param teamNo 팀번호
     * @return TeamMemberListDto
     */
    @Query("SELECT new com.beyond.backend.data.dto.teamDto.TeamMemberListDto" +
            "(u.no, u.username, tu.isLeader, tu.status) " +
            "FROM Team t " +
            "JOIN TeamUser tu ON t.no = tu.team.no " +
            "JOIN User u ON u.no = tu.user.no " +
            "WHERE t.no = :teamNo")
    List<TeamMemberListDto> findByTeamNoForLeader(@Param("teamNo") Long teamNo);

    /**
     * 해당 팀의 활성 팀원 조회
     * @param teamNo 팀번호
     * @return TeamMemberListDto
     */
    @Query("SELECT new com.beyond.backend.data.dto.teamDto.TeamMemberListDto" +
            "(u.no, u.username, tu.isLeader, tu.status) " +
            "FROM Team t " +
            "JOIN TeamUser tu ON t.no = tu.team.no " +
            "JOIN User u ON u.no = tu.user.no " +
            "WHERE t.no = :teamNo AND tu.status = true")
    List<TeamMemberListDto> findByTeamNoForNonLeader(@Param("teamNo") Long teamNo);




}
