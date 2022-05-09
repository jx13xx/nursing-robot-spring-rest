package com.example.nursingrobotspringrest.patient;

import org.springframework.stereotype.Service;

@Service
public interface PatientServiceImpl extends PatientRepository{

    default boolean patientExist(String lastname){
      return existsPatientsByLastName(lastname);
    }

}
