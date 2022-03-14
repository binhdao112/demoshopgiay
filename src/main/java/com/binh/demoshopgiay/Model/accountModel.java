package com.binh.demoshopgiay.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Document("account")
@Setter
@Getter
@NoArgsConstructor
public class accountModel {
    @Id
    String id= UUID.randomUUID().toString().replace("-","");
    @Field("name")
    String name;
    @NotBlank(message = "name is not blank")
    @Field("email")
    String email;
    @NotBlank(message = "name is not blank")
    @Field("password")
    String password;
    @Field("role")
    String role;

    public accountModel(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
