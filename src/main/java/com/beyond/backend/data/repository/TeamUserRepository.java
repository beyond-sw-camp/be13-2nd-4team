package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : TeamRepository
 * <p>author         : hongjm
 * <p>date           : 2025-02-16
 * <p>description    : 유저와 팀을 잇는 팀구성 Repository
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-16        hongjm           최초 생성
 */

public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {
    List<TeamUser> findByUserNo(Long userNo);
    List<TeamUser> findByTeamNo(Long teamNo);
}
