package org.example.PatientDoctor.Repository;

import org.example.PatientDoctor.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
