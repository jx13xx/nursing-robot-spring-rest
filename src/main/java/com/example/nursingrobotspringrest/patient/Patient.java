package com.example.nursingrobotspringrest.patient;

import com.example.nursingrobotspringrest.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;


@Entity
public class Patient extends BaseEntity {

    @Column(name= "patient_firstname", unique = true)
    private String patient_firstname;

    @Column(name ="lastName", unique = true)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Override
    public String toString() {
        return "Patient{" +
                "patient_firstname='" + patient_firstname + '\'' +
                ", patient_lastname='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", blood_group='" + blood_group + '\'' +
                '}';
    }

    public Patient() {
    }

    public Patient(String patient_firstname, String patient_lastname, Integer age, String gender, String blood_group) {
        this.patient_firstname = patient_firstname;
        this.lastName = patient_lastname;
        this.age = age;
        this.gender = gender;
        this.blood_group = blood_group;
    }

    public String getPatient_firstname() {
        return patient_firstname;
    }

    public void setPatient_firstname(String patient_firstname) {
        this.patient_firstname = patient_firstname;
    }

    public String getPatient_lastname() {
        return lastName;
    }

    public void setPatient_lastname(String patient_lastname) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    private String  blood_group;

}
