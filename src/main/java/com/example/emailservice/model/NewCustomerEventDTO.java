package com.example.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewCustomerEventDTO {
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private String phone;
}
