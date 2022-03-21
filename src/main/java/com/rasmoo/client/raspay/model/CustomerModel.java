package com.rasmoo.client.raspay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("customer")
public class CustomerModel implements Serializable {

    @Id
    private String id;
    @Indexed(unique=true)
    private String email;
    @Indexed(unique=true)
    private String telephone;
    private String firstName;
    private String lastName;


}
