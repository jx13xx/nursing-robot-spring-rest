package com.example.nursingrobotspringrest.patient;

import com.example.nursingrobotspringrest.dto.CustomResponse;
import com.example.nursingrobotspringrest.exceptions.ConflictErrorException;
import com.example.nursingrobotspringrest.exceptions.NotFoundErrorException;
import com.example.nursingrobotspringrest.utility.FileWrite;
import com.example.nursingrobotspringrest.utility.OKHttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.example.nursingrobotspringrest.constants.Constants.PATIENT_CREATED_SUCESSFULLY;
import static com.example.nursingrobotspringrest.constants.Constants.PATIENT_FAILED_TO_CREATED;
import static com.example.nursingrobotspringrest.constants.Constants.NO_PATIENT_FOUND;

@Component
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    PatientServiceImpl db;

    @Autowired
    OKHttpConnection pyclient;

    @Autowired
    FileWrite uploadFile;

    public Map<String, String> savePatient(Patient patient){
        CustomResponse response = new CustomResponse();
        try{

            String previousPatient = patient.getlastName();
            if(!db.patientExist(previousPatient)){

                 patientRepository.save(patient);


                 return response.returnMessage(PATIENT_CREATED_SUCESSFULLY, patient.getId().toString());

            }

        }catch (Exception ex){
            System.out.println(ex);

        }
        throw new ConflictErrorException(PATIENT_FAILED_TO_CREATED);
    }

    public List<Patient> fetchAllPatients(){
        try {


            return patientRepository.findAll();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        throw new NotFoundErrorException(NO_PATIENT_FOUND);
    }

    public Optional<Patient> fetchSpecificPatient(String uuid){
        UUID patientID = UUID.fromString(uuid);

        Optional<Patient> patient = patientRepository.findById(patientID);

            if(!patient.isPresent()){
                throw new NotFoundErrorException(NO_PATIENT_FOUND);
            }

        return  patientRepository.findById(patientID);
    }

    public String identifyPatient(MultipartFile file){
        try {
           String uploadedFile =  uploadFile.writeToServer(file);
            pyclient.sendRequest(uploadedFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        return pyclient.sendRequest(file);
        return "file saved";
    }

}
