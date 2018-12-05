package com.zenmonics.springboot.restservices.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "All details about the user")
public class User implements Serializable{
    private int id;

    @ApiModelProperty(notes = "Name should be minimum 2 char long")
    @Size(min = 2, message = "{name.min.length}")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date has to be in the past")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    public User() {
        //default constructor
    }

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
