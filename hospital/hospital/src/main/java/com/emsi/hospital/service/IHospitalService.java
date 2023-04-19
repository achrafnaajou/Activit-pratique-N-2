package com.emsi.hospital.service;

import com.emsi.hospital.entities.Consultation;
import com.emsi.hospital.entities.Medecin;
import com.emsi.hospital.entities.Patient;
import com.emsi.hospital.entities.RendezVous;

public interface IHospitalService {
    //couche metier
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
