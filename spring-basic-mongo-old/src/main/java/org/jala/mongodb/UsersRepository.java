package org.jala.mongodb;

import org.jala.models.UsersModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Richard Severich on 28/10/2017.
 */
@Repository
public interface UsersRepository extends MongoRepository<UsersModel,String> {
}
