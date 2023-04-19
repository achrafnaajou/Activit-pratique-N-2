package com.emsi.hospital.repositories;

import com.emsi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
 Patient findByName(String Name);

}
