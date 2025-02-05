package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

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
 */

public interface TeamRepository extends JpaRepository<Team, Long> {
}
