package edu.cjc.main.serviceI;

import java.util.List;

import edu.cjc.main.model.Student;

public interface StudentServiceI {

	public void saveStudentDetails(Student s);
	public List<Student> getAllStudents();
	public List<Student> searchStudentsByBatch(String batchNumber);
	public Student getSingleStudent(int id);
	public void updateStudentFees(int studentid, float ammount);
	public void updateStudentBatch(int studentId, String batchNumber);
	public List<Student> deleteStudent(int id);

}
