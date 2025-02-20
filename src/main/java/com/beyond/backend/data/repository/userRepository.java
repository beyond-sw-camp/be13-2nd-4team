package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : UserRepository
 * <p>author         : hongjm
 * <p>date           : 25. 02. 19.
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 02. 19.        hongjm             최초 생성
 */

public interface userRepository extends JpaRepository<User, Long> {
}
