package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {

}
