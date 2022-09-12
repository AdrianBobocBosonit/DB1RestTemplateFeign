package com.bosonit.DB1RestTemplateFeign;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Persona {
    private String id;
    private String usuario;
    private String student;
    private String profesor;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private String active;
    private String createdDate;
    private String imagenUrl;
    private String terminationDate;
}
