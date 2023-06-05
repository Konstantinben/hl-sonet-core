package com.sonet.core.repository;

import com.sonet.core.model.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUuid(UUID uuid);

/*    @Query("" +
            "SELECT " +
            "us.first_name, \n" +
            "us.last_name, \n" +
            "us.id, \n" +
            "us.age, \n" +
            "us.role, \n" +
            "us.city, \n" +
            "us.uuid, \n" +
            "us.email, \n" +
            "us.gender, \n" +
            "us.birthdate, \n" +
            "us.biography \n" +
            "FROM \"users\" us \n" +
            "WHERE us.first_name LIKE :firstName \n" +
            "AND us.last_name LIKE :lastName ")
    List<User> findByFirstAndLastNames(String firstName, String lastName);*/

    @Query("" +
            "SELECT " +
            "us.first_name, \n" +
            "us.last_name, \n" +
            "us.id, \n" +
            "us.age, \n" +
            "us.role, \n" +
            "us.city, \n" +
            "us.uuid, \n" +
            "us.email, \n" +
            "us.gender, \n" +
            "us.birthdate, \n" +
            "us.biography \n" +
            "FROM \"users\" us \n" +
            "WHERE us.first_name LIKE '%' || :firstName || '%'\n" +
            "AND us.last_name LIKE '%' || :lastName || '%'")
    List<User> findLikeFirstAndLastNames(String firstName, String lastName);

    List<User> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);
}
