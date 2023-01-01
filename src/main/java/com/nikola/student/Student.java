package com.nikola.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Student {
	@Id
	@SequenceGenerator(name = "studentSequence",sequenceName = "studentSequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="studentSequence")
private Long id;
private String name;
private String email;
private LocalDate dateOfBirth;
@Transient //transient veli deka age vo ovoj slucaj nema potreba da bide kolona vo nasata databaza t.e age ke bide presmetan za nas
//iako age ne postoi kako kolona vo nasata tabela Student, sepak age se presmetuva
private Integer age;
public Student(Long id, String name, String email, LocalDate dateOfBirth) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.dateOfBirth = dateOfBirth;
	
}

public Student() {
	
}

public Student(String name, String email, LocalDate dateOfBirth) {
	super();
	this.name = name;
	this.email = email;
	this.dateOfBirth = dateOfBirth;

}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public Integer getAge() {
	return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
}

public void setAge(Integer age) {
	this.age = age;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", age=" + age
			+ "]";
}







}
