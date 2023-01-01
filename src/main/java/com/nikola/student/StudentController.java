package com.nikola.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController //sega ova klasa ke bide nasiot RestController
public class StudentController {//klasa koja ke sluzi kako API layer i ke gi ima site resursi za nasiot API
private final StudentService studentService;
	//referenca kon studentService
	
	@Autowired //za da kazeme private final StudentService studentService; treba da bide injected vo new_studentService
	//ili bilo so, so passing vo ovoj konstruktor treba da bide injected vo new_studentService
	//so @Autowired kazuvame deka ovoj private final StudentService studentService; treba da bide autowired t.e injected vo new_studentService
	//isto taka treba da kazeme deka private final StudentService studentService; e klasa koja treba da bide instancirana t.e
	//da bide Spring Bean, za da go napravime toa odime vo StudentService klasata
	public StudentController(StudentService new_studentService) {
	super();
	//ova nema da raboti bidejki nemame instanca od StudentService, StudentService ne e inicijalizirano nikade vo ovaa klasa
	
	this.studentService = new_studentService;
}


	@GetMapping("/student")//get method
	public List<Student> getStudents() {
		//return List.of(new Student(1L,"Nikola","nikolajanev57@yahoo.com",LocalDate.of(2000, Month.DECEMBER, 21),22));
		//sega ke morame da go koristime service layerot da gi zemime ovie podatoci za da gi zemime podatocite za studentite
		//sega vikame:
		return studentService.getStudents();
	}
	
	@PostMapping("/student")
	public void registerNewStudent(@RequestBody NewStudentRequest newStudentRequest) {
	studentService.addStudent(newStudentRequest);
}
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id) {
		studentService.deleteStudent(id);
		
	}
}