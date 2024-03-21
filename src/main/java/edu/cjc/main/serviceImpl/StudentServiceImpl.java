package edu.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.main.model.Student;
import edu.cjc.main.repository.StudentRepositoryI;
import edu.cjc.main.serviceI.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepositoryI sr; 
	@Override
	public void saveStudentDetails(Student s) {
		
		sr.save(s);
		
	}
	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
		
	}
	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		
		List<Student> batchStudent= sr.findAllByBatchNumber(batchNumber);
		return batchStudent;
		
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> ops=sr.findById(id);
		return ops.get();
	}  


	@Override
	public void updateStudentFees(int studentid, float ammount) {
		Optional<Student> ops=sr.findById(studentid);
			Student st=ops.get();
			
			st.setFeesPaid(st.getFeesPaid()+ammount);
					sr.save(st);	
	}
	@Override
	public void updateStudentBatch(int studentId, String batchNumber) {
			Optional<Student> opStudent = sr.findById(studentId);
			Student st = opStudent.get();
			st.setBatchNumber(batchNumber);
			sr.save(st);
		
	}

	@Override
	public List<Student> deleteStudent(int id) {
	sr.deleteById(id);
		return getAllStudents();
	}

}
