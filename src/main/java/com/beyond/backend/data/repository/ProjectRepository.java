package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : ProjectRepository
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 2.
 * <p>description    : 프로젝트 Repository
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 2.        jaewoo             최초 생성
 * 2025. 2. 2.        jaewoo             오타 수정
 * 2025. 2. 17.       jaewoo             findByTeamNo 함수 생성
 */

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByTeamNo(Long teamNo);
}
