package com.emsi.hospital;

import com.emsi.hospital.entities.*;
import com.emsi.hospital.repositories.ConsultationRepository;
import com.emsi.hospital.repositories.MedecinRepository;
import com.emsi.hospital.repositories.PatientRepository;
import com.emsi.hospital.repositories.RendezVousRepository;
import com.emsi.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

    }
@Bean
   CommandLineRunner start(IHospitalService iHospitalService,
                           PatientRepository patientRepository,
                           MedecinRepository medecinRepository,
                           RendezVousRepository rendezVousRepository,
                           ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("mina", "miloud", "jawad").forEach(name->{
                Patient patient = new Patient();
                patient.setName(name);
                patient.setDataNaissance(new Date());
                patient.setMalade(false);
                iHospitalService.savePatient(patient);

            });
            Stream.of("Oussama", "Zaza", "yassmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                iHospitalService.saveMedecin(medecin);

            });
            Patient patient1 = patientRepository.findById(1L).orElse(null);
            Patient patient2 = patientRepository.findByName("miloud");
            Medecin m1= medecinRepository.findByName("yassmine");

            RendezVous RDV= new RendezVous();
            RDV.setDate(new Date());
            RDV.setStatus(StatusRDV.PENDING);
            RDV.setPatient(patient2);
            RDV.setMedecin(m1);
            iHospitalService.saveRendezVous(RDV);

            Consultation cns = new Consultation();
            cns.setDateConsultation(new Date());
            cns.setRendezVous(RDV);
            cns.setRepport("Rapport de la consultation ...");
            iHospitalService.saveConsultation(cns);

        };
   }


}
