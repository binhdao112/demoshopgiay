package com.binh.demoshopgiay.Repository;

import com.binh.demoshopgiay.Model.accountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
<<<<<<< HEAD
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
=======

import java.util.List;

>>>>>>> f0f0c7dfbb985317d35cf113345ca3aeabe0b27a
public interface accountRepository extends MongoRepository<accountModel, String> {
    @Query("{email : ?0}")
    List<accountModel> findaccountModelByEmail(String email);

    @Query("{email: ?0, password: ?1}")
    List<accountModel> findaccountModelByEmailAndPass(String email, String password);
}
