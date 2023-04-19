package com.emsi.hospital.service;

import com.emsi.hospital.entities.Consultation;
import com.emsi.hospital.entities.Medecin;
import com.emsi.hospital.entities.Patient;
import com.emsi.hospital.entities.RendezVous;
import com.emsi.hospital.repositories.ConsultationRepository;
import com.emsi.hospital.repositories.MedecinRepository;
import com.emsi.hospital.repositories.PatientRepository;
import com.emsi.hospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
//les objets de la couche service utilise la notation service
@Service
//toutes les methodes doit seron transactional care les operation de la couche metier son transactional
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation );
    }
}
