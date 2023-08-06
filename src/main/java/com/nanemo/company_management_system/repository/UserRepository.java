package com.nanemo.company_management_system.repository;

import com.nanemo.company_management_system.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.positionList p WHERE p.name = :positionName")
    List<User> findUsersWithPositionName(@Param("positionName") String positionName);

    Optional<User> findUserByLogin(String login);
}
