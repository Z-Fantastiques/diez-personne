package com.diez_personne.repository;

import com.diez_personne.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by linard_f on 1/27/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);

}
