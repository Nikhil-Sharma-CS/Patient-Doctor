package org.example.PatientDoctor.Service;

import lombok.AllArgsConstructor;
import org.example.PatientDoctor.Model.Doctor;
import org.example.PatientDoctor.Model.Enums.City;
import org.example.PatientDoctor.Model.Enums.Symptom;
import org.example.PatientDoctor.Model.Patient;
import org.example.PatientDoctor.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    DoctorService doctorService;

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public String addPatient(Patient patient) {
        patientRepo.save(patient);
        return "Patient saved";
    }

    public String deletePatient(Integer id) {
        if(!patientRepo.existsById(id))
            return "Patient does not exists";

        patientRepo.deleteById(id);
        return "Patient deleted";
    }

    //Here we check if we can suggest the doc to our patient or not
    public String suggest(Integer id) {
        //First check if Patient id is valid or not
        Patient patient = patientRepo.findById(id).orElse(null);

        if(patient==null)
            return "Patient by Id not Found";

        //Now our patient is valid, so we try to suggest doc to him
        //Let's first check if patient city is covered by us or not
        String patientCity = patient.getPatientCity();

        if(!patientCity.equals("Delhi"))
        {
            if(!patientCity.equals("Noida"))
            {
                if(!patientCity.equals("Faridabad"))
                {
                    return "We are still waiting to expand to your location";
                }
            }
        }

        //Now here our patient is in our city, so we check for the symptom match
        //First find doctors for that symptom
        Symptom symptom = patient.getSymptom();

        //Getting the doctor for that symptom and city
        Doctor doctor = doctorService.findDoc(symptom, patientCity);

        if(doctor == null)
            return "There isn’t any doctor present at your location for your symptom";

        return "Doctor is : " + doctor;
    }
}
