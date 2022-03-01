package com.rasmoo.client.raspay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("customer")
public class CustomerModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
}
