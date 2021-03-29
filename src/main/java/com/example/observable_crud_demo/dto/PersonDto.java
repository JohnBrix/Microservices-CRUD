package com.example.observable_crud_demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonDto {

    private Integer id;
    @NotBlank(message = "Firstname cannot be blank!")
    @NotNull
    private String firstName;
    @NotBlank(message = "Lastname cannot be blank!")
    @NotNull
    private String lastName;
    @NotNull(message = "BirthDate cannot be blank!")
    private Date birthDate;
    @NotNull(message = "Age cannot be null")
    private Integer age;
    @NotBlank(message = "Address cannot be blank!")
    @NotNull
    private String address;
    private Date dateCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
