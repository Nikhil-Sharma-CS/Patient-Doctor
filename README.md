
# Patient-Doctor

This is an appilcation which will suggest Patient a Doctor according to their Symptom and the City they are located in.

Here Patient and Doctors can also register their information.

This project is built using SpringBoot with Java using MVC architecture.



## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer trainee at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot.


# Data Flow

## Controller Section
-   *This section contains a Doctor Controller Class and a Patient Controller class* :

* ### Doctor Controller
    - This class contains 3 Types of APIs which helps to add, read and delete doctor info.

    * @GetMapping("doctors")
    * @PostMapping("doctor")
    * @DeleteMapping("doctor/{Id}")


* ### Patient Controller
    - This class contains 4 APIs where 1 of them is used to suggest doctors to patient.

    * @GetMapping("patients")
    * @PostMapping("patient")
    * @DeleteMapping("patient/{Id}")
    * @GetMapping("Suggest/{Id}")

## Service Section

- *This section contains 2 classes each of which contains methods for buisness logics of the APIs*

* ### Doctor Service Class

    * List<Doctor> getDoctors()
    * String addDoctor(Doctor doctor)
    * String deleteDoctor(Integer id)
    * Doctor findDoc(Symptom symptom, String patientCity)
    * Speciality getSpeciality(Symptom symptom)

* ### Patient Service Class

    * List<Patient> getPatients()
    * String addPatient(Patient patient)
    * String deletePatient(Integer id)
    * String suggest(Integer id)

## Model Section

- *This section contains 2 models which are used as tables to store data in our database.*
- ***Doctor** and **Patient** are our two models.*
- *This section also contains various enums to provide functionality to our application.*

## Repository Section

- *This section contains 2 Repositories each corresponding to our 2 models.*

- *They all extend **JPA Repository**.*

## Database Design
- *Here we have used Relational Data to store information about our patients and doctors.*

- *We have used MYSQL and the database is hosted on a local server.*

## ScreenShots

- Below are some snaps of how the APIs would look like in Swagger and Code.

  - PatientController 
   ![Screenshot (9)](https://github.com/Nikhil-Sharma-CS/Patient-Doctor/assets/72157075/96a57ae3-3422-4c29-831c-0fee8323e7a5)

  - DoctorController
    ![Screenshot (11)](https://github.com/Nikhil-Sharma-CS/Patient-Doctor/assets/72157075/5404b7bb-f017-4201-aa1a-ac6617a0dbcd)

  - GetPatient API
    ![Screenshot 2023-09-07 at 22-37-07 Swagger UI](https://github.com/Nikhil-Sharma-CS/Patient-Doctor/assets/72157075/9022deaf-ce40-42a5-baf5-6ca3e429b045)

  - GetDoctor API
    ![Screenshot 2023-09-07 at 22-37-44 Swagger UI](https://github.com/Nikhil-Sharma-CS/Patient-Doctor/assets/72157075/a583a79e-d73c-4faf-91a9-4b03dafb0777)

  - Get Suggestion API
    ![Screenshot 2023-09-07 at 22-38-24 Swagger UI](https://github.com/Nikhil-Sharma-CS/Patient-Doctor/assets/72157075/b1a09c5d-fb46-4ad2-8adf-0c83661f6c14)

## Summary

*This project demonstrates how a system can suggest a doctor to a patient based on symptoms and city they are in. The patient just have to register in the app and give their Id, then our app will suggest them appropriate doctor.*

*This is coded in **Java** language.*
## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)


