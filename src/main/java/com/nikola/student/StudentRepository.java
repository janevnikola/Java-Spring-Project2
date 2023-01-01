package com.nikola.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//Repository e nacin na imenuvanje za se so pristapuva do databaza
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	//SELECT *
	//FROM Student
	//WHERE email=?
	//proveri dali postoi student so email email
	Optional<Student> findStudentByEmail(String email);
}
