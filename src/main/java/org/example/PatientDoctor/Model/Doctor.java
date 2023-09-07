package org.example.PatientDoctor.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.PatientDoctor.Model.Enums.City;
import org.example.PatientDoctor.Model.Enums.Speciality;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String docName;

    @Enumerated(EnumType.STRING)
    private City docCity;

    @Email(message = "Please enter a valid email")
    private String docEmail;

    @Length(max = 10, message = "Please enter max 10 numbers")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
