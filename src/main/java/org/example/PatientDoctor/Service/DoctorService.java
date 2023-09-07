package org.example.PatientDoctor.Service;

import org.example.PatientDoctor.Model.Doctor;
import org.example.PatientDoctor.Model.Enums.Speciality;
import org.example.PatientDoctor.Model.Enums.Symptom;
import org.example.PatientDoctor.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    public String addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
        return "Doctor saved";
    }

    public String deleteDoctor(Integer id) {
        if(!doctorRepo.existsById(id))
            return "Doctor does not exists";

        doctorRepo.deleteById(id);

        return "Doctor deleted";
    }

    public Doctor findDoc(Symptom symptom, String patientCity) {
        //Firstly get list of doctors based on symptom
        List<Doctor> doctors = doctorRepo.findAll();

        //First find suggested speciality
        Speciality suggested = getSpeciality(symptom);

        List<Doctor> probableDocs = new ArrayList<>();
        for(Doctor doctor : doctors)
        {
            if(doctor.getSpeciality().equals(suggested))
                probableDocs.add(doctor);
        }

        //Now check how many of them are in the city
        //And if they are in the city than return the very first we could find else return null
        for(Doctor doctor : probableDocs)
        {
            if(doctor.getDocCity().toString().equals(patientCity))
                return doctor;
        }

        return null;
    }

    private static Speciality getSpeciality(Symptom symptom) {
        Speciality suggested = null;

        if(symptom.equals(Symptom.Arthritis) || symptom.equals(Symptom.TissueInjuries) || symptom.equals(Symptom.BackPain))
            suggested = Speciality.Orthopedic;

        if(symptom.equals(Symptom.Dysmenorrhea))
            suggested = Speciality.Gynecology;

        if(symptom.equals(Symptom.SkinBurn) || symptom.equals(Symptom.SkinInfection))
            suggested = Speciality.Dermatology;

        if(symptom.equals(Symptom.EarPain))
            suggested = Speciality.ENT;
        return suggested;
    }
}
