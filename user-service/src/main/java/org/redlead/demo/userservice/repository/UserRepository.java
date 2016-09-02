package org.redlead.demo.userservice.repository;

import org.redlead.demo.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByKey(String key);
}
