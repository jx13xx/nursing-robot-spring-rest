package com.example.nursingrobotspringrest.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> retrieveAllPatients(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", patientService.fetchAllPatients());

        return map;

    }

    @GetMapping("/retrievePatient")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> retriveSpecificPatient(@RequestParam(name = "id", required = true) String uuid){
        return patientService.fetchSpecificPatient(uuid);

    }
}
