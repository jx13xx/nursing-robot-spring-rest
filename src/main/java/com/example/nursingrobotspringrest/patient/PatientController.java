package com.example.nursingrobotspringrest.patient;

import com.example.nursingrobotspringrest.dto.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.nursingrobotspringrest.constants.Constants.PATIENT_CREATED_SUCESSFULLY;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> savePatient(@RequestBody Patient saveRequest) {
        Map<String, String> response = patientService.savePatient(saveRequest);


        return response;

    }
}
