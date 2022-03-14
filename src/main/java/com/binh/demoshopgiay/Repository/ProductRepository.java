package com.binh.demoshopgiay.Repository;

import com.binh.demoshopgiay.Model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
}
