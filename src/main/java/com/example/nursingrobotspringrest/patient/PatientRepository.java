package com.example.nursingrobotspringrest.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    /**
     * Retrieve and check if a user has been saved
     */
    boolean existsPatientsByLastName(String patient_lastname);


    /**
     * Save an {@link Patient} to the data store, either inserting or updating it.
     * @return
     */
    Patient save(Patient patient);

    /*
     * Retrieve patient with some specific idd
     */
    Optional<Patient> findById(UUID uuid);

}
