package org.example.PatientDoctor.Controller;

import jakarta.validation.Valid;
import org.example.PatientDoctor.Model.Doctor;
import org.example.PatientDoctor.Model.Patient;
import org.example.PatientDoctor.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PatientController {

    @Autowired
    PatientService patientService;

    //CRUD APIs for Patient

    @GetMapping("patients")
    public List<Patient> getPatients()
    {
        return patientService.getPatients();
    }

    @PostMapping("patient")
    public String addPatient(@RequestBody @Valid Patient patient)
    {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("patient/{Id}")
    public String deletePatient(@PathVariable Integer Id)
    {
        return patientService.deletePatient(Id);
    }


    //For Suggesting Doctors
    @GetMapping("Suggest/{Id}")
    public String suggest(@PathVariable Integer Id)
    {
        return patientService.suggest(Id);
    }
}
