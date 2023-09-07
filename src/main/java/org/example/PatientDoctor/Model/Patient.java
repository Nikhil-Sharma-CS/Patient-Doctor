package org.example.PatientDoctor.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.PatientDoctor.Model.Enums.Symptom;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(min = 3, message = "Please enter at least 3 characters for name")
    private String patientName;

    @Length(max = 20, message = "Max length of City should be 10")
    private String patientCity;

    @Email(message = "Please enter a valid email")
    private String patientEmail;

    @Length(max = 10, message = "Please enter phone number of max 10")
    private String patientPhone;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;
}
