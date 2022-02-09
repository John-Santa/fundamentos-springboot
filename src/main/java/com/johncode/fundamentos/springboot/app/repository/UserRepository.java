package com.johncode.fundamentos.springboot.app.repository;

import com.johncode.fundamentos.springboot.app.dto.UserDto;
import com.johncode.fundamentos.springboot.app.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //JPQL
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    Optional<User> findByName(String name);
    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSortByName(String name, Sort sort);

    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthdateBetween(LocalDate startDate, LocalDate endDate);
    List<User> findByNameOrderByIdDesc(String name);

    //Named parameters
    Optional<UserDto> getAllByBirthdateAndEmail(LocalDate birthdate, String email);
    //jpql
    @Query("SELECT NEW com.johncode.fundamentos.springboot.app.dto.UserDto(u.id, u.name, u.birthdate) " +
            "FROM User u " +
            "WHERE u.birthdate = :birthdate AND u.email = :email")
    Optional<UserDto> getAllByBirthdateAndEmailNamed(@Param("birthdate") LocalDate birthdate,
                                                     @Param("email") String email);
}