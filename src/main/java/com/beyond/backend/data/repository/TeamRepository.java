package com.beyond.backend.data.repository;

import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : TeamRepository
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 
 */
 /*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 *
 */

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT new com.beyond.backend.data.dto.TeamSearchDto(t.teamName, t.teamIntroduce, t.projectStatus, t.timePeriod.createdAt) " +
            "FROM User u " +
            "JOIN TeamUser tu ON u.no = tu.user.no " +
            "JOIN Team t ON tu.team.no = t.no " +
            "WHERE u.no = :userNo")
    List<TeamSearchDto> findUserTeams(@Param("userNo") Long userNo);
}
