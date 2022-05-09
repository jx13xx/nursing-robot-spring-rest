package com.example.nursingrobotspringrest.patient;

import com.example.nursingrobotspringrest.dto.CustomResponse;
import com.example.nursingrobotspringrest.exceptions.ConflictErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

import static com.example.nursingrobotspringrest.constants.Constants.PATIENT_CREATED_SUCESSFULLY;
import static com.example.nursingrobotspringrest.constants.Constants.PATIENT_FAILED_TO_CREATED;


@Component
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    PatientServiceImpl db;

    public Map<String, String> savePatient(Patient patient){
        CustomResponse response = new CustomResponse();
        try{

            String previousPatient = patient.getPatient_lastname();
            if(!db.patientExist(previousPatient)){
                System.out.println("Patient saved properly");
                 patientRepository.save(patient);
                 

                 return response.returnMessage(PATIENT_CREATED_SUCESSFULLY, patient.getId().toString());

            }

        }catch (Exception ex){
            System.out.println(ex);

        }
        throw new ConflictErrorException(PATIENT_FAILED_TO_CREATED);
    }

}
