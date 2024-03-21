package edu.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.main.model.Student;
import edu.cjc.main.serviceI.StudentServiceI;

@Controller
public class AdminController {

	@Autowired
	StudentServiceI sr;

	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam String username,@RequestParam String password,Model m)
	{
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			List<Student> list=sr.getAllStudents();
			m.addAttribute("data", list);
			return "adminscreen";
		}else
			{
				m.addAttribute("login_fail","Enter valid login Detail");
			}
			return "login";
			}
	@RequestMapping("enrollStudent")
	public String saveStudent(@ModelAttribute Student s,Model m)
	{
		sr.saveStudentDetails(s);
		List<Student> students=sr.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m)
	{
		List<Student> list=sr.searchStudentsByBatch(batchNumber);
		List<Student> l1=sr.getAllStudents();
				if(list.size()>0)
				{
					m.addAttribute("data", list);
				}else if(batchNumber.equals("#"))
					{
						m.addAttribute("data", l1);
						m.addAttribute("message", "please select any of Batch");
					}else
						{
							m.addAttribute("data", l1);
							m.addAttribute("message", "No Record Found For This Batch : "+batchNumber);
						}
				return "adminscreen";
	}
	@RequestMapping("/fees")							
	public String onFees(@RequestParam int id,Model m)
	{
		Student st=sr.getSingleStudent(id);
		m.addAttribute("st", st);
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid,@RequestParam float ammount,Model m)
	{
		sr.updateStudentFees(studentid,ammount);
		List<Student> student=sr.getAllStudents();
		m.addAttribute("data",student);
			return "adminscreen";
	}
	@RequestMapping("/batch")
	public String onBatch(@RequestParam int id, Model m)
	{
		Student st =sr.getSingleStudent(id);
		m.addAttribute("st", st);
		return "batch";
	}
	
	@RequestMapping("shiftbatch")
	public String shiftBatch(@RequestParam int studentId, @RequestParam String batchNumber,Model m) {
		sr.updateStudentBatch(studentId,batchNumber);
		List<Student> list=sr.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam int id,Model m)
	{
		List<Student> list= sr.deleteStudent(id);
		m.addAttribute("data", list);
		return "adminscreen";
	}

}
