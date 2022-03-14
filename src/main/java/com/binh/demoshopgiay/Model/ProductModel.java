package com.binh.demoshopgiay.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collections;
import java.util.UUID;

@Document("product")
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {
    @Id
    String id= UUID.randomUUID().toString().replace("-","");
    @Field("nameproct")
    String name;
    @Field("image")
    String image;
    @Field("price")
    Double price;
    @Field("count")
    int count;

    public ProductModel(String name, String image, Double price, int count) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.count = count;
    }
}
