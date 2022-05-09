package com.example.nursingrobotspringrest.patient;

import com.example.nursingrobotspringrest.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Patient extends BaseEntity {

    @Column(name= "patient_firstname" )
    private String patient_firstname;

    @Column(name ="lastName")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    public boolean isCovid() {
        return isCovid;
    }

    public void setCovid(boolean covid) {
        isCovid = covid;
    }



    private boolean isCovid;

    @Override
    public String toString() {
        return "Patient{" +
                "patient_firstname='" + patient_firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", isCovid=" + isCovid +
                ", blood_group='" + blood_group + '\'' +
                '}';
    }

    public Patient() {
    }

    public Patient(String patient_firstname, String lastName, Integer age, String gender, boolean isCovid, String blood_group) {
        this.patient_firstname = patient_firstname;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.isCovid = isCovid;
        this.blood_group = blood_group;
    }

    public String getPatient_firstname() {
        return patient_firstname;
    }

    public void setPatient_firstname(String patient_firstname) {
        this.patient_firstname = patient_firstname;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
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
