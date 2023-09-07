package org.example.PatientDoctor.Controller;

import jakarta.validation.Valid;
import org.example.PatientDoctor.Model.Doctor;
import org.example.PatientDoctor.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //CRUD APIs for Doctors

    @GetMapping("doctors")
    public List<Doctor> getDoctors()
    {
        return doctorService.getDoctors();
    }

    @PostMapping("doctor")
    public String addDoctor(@RequestBody @Valid Doctor doctor)
    {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("doctor/{Id}")
    public String deleteDoctor(@PathVariable Integer Id)
    {
        return doctorService.deleteDoctor(Id);
    }
}
