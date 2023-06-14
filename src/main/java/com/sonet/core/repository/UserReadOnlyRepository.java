package com.sonet.core.repository;

import com.sonet.core.configuration.jdbc.ReadOnlyRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
@ReadOnlyRepository
public interface UserReadOnlyRepository<T, ID> extends Repository<T, ID> {
    Optional<T> findByUuid(ID uuid);
    List<T> findLikeFirstAndLastNames(String firstName, String lastName);
}