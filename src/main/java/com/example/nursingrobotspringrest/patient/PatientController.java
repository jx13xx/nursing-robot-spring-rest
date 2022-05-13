package com.example.nursingrobotspringrest.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @GetMapping("/face")
    @ResponseStatus(HttpStatus.OK)
    public String recognizeFace(@RequestParam("file") MultipartFile file) throws IOException {


       return patientService.identifyPatient(file);

    }

//    @RequestMapping(value = "/redirect", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
//    public ResponseEntity<?> registerBatchUser(@RequestParam("file") MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(new File("D:\\myfileredirect.csv")));
//                stream.write(bytes);
//                stream.close();
//
//
//            } catch (Exception e) {
//                JwtAuthenticationErrorResponse FeedBackResponse = new JwtAuthenticationErrorResponse();
//                FeedBackResponse.setCode(100);
//                FeedBackResponse.setMessage(e.getMessage());
//                Map<String, Object> FeedBackStatus = new HashMap<String, Object>();
//                FeedBackStatus.put("status", FeedBackResponse);
//                return ResponseEntity.ok(FeedBackStatus);
//            }
//            MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
//            parameters.add("file", new FileSystemResource("D:\\myfileredirect.csv"));
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Content-Type", "multipart/form-data");
//
//
//
//            Map<String, Object> FeedBackStatus=new HashMap<String, Object>();
//            FeedBackStatus =  restTemplateUserRegitration.exchange("http://localhost:8080/upload",  HttpMethod.POST,  new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), Map.class).getBody();
//            return ResponseEntity.ok(FeedBackStatus);
//
//        }
}
