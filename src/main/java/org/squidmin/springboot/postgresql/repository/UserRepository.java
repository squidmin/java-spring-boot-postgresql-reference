package org.squidmin.springboot.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.squidmin.springboot.postgresql.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
