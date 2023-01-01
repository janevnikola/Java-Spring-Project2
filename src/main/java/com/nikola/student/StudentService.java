package com.nikola.student;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//so ova StudentController t.e API layer razgovara so StudentService t.e so Service Layers
//@Component
@Service
public class StudentService {//ova e klasa koja ke sluzi kako business layer ili service layer t.e logika za menadziranje na
	//studenti
	//API layer treba da zboruva so Service layer za da zeme podatoci i Service Layerot treba da zboruva so Data Access layer za da zeme
	//podatoci t.e app ke raboti klient->API layer->Service Layer->Data Access Layer->baza
	//service layerot e odgovoren za biznis logikata
	
	//Za da kazeme deka ovaa klasa e Spring Bean, koristime @Component ili @Service (imaat isto znacenje, no posemanticki tocno e @Service)
	
	private  StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository newStudentRepository) {
	this.studentRepository=newStudentRepository;
}
	
	public List<Student> getStudents() {
	return studentRepository.findAll();
	}
	public void addStudent(@RequestBody NewStudentRequest newStudentRequest) {
		Student student=new Student();
		student.setAge(newStudentRequest.getAge());
		student.setEmail(newStudentRequest.getEmail());
		student.setDateOfBirth(newStudentRequest.getDateOfBirth());
		student.setName(newStudentRequest.getName());
		Optional<Student>studentByEmail=studentRepository.findStudentByEmail(newStudentRequest.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email is already taken");	
		}
		else {
			studentRepository.save(student);	 
			
		}
	}

	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		boolean exists=studentRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Student with" +id+"does not exist");
		}
		else {
			studentRepository.deleteById(id);
		}
		
		
	}

}
