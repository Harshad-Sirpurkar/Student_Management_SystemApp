package edu.cjc.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String studentFullName;
	private String studentEmail;
	private int studentAge;
	private String studentCollegeName;
	private String studentCourse;
	private String batchNumber;
	private String batchMode;
	private float feesPaid;
}
