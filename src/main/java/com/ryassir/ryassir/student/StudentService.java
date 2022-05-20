package com.ryassir.ryassir.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
@Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {

        return studentRepo.findAll();
    }

    public void addNewStudent(  Student student) {
         Optional<Student> studentByEmail=studentRepo.findStudentByEmail(student.getEmail());
    if(studentByEmail.isPresent()){
        throw new IllegalStateException("email taken");
    }
     studentRepo.save(student);
     System.out.println(student.getEmail());
    }

    public void deleteStudent(Long studentid) {
      boolean exists=studentRepo.existsById(studentid);
      if(!exists){
       throw new IllegalStateException("Studen with "+studentid+" doesnt exist");
      }
      studentRepo.deleteById(studentid);

    }
 @Transactional
    public void updateStudent(Long studentId, String name, String email) {
Student student=studentRepo.findById(studentId).
        orElseThrow(()->new IllegalStateException(("student with "+studentId+" doesnt exist")));
  if(name!=null&&name.length()>0 && !Objects.equals(student.getName(),name)) {
      student.setName(name);
  }
  if(email!=null&&email.length()>0&& !Objects.equals(student.getEmail(),email)){

      Optional<Student> studentOptional=studentRepo.findStudentByEmail(email);
      if(studentOptional.isPresent()){
          throw new IllegalStateException("email taken");
      }
      student.setEmail(email);



  }


    }
}
