package in.springbootjdbc.springBootJDBC;

import in.springbootjdbc.springBootJDBC.model.Student;
import in.springbootjdbc.springBootJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setRollNo(102);
		student.setName("RS");
		student.setMarks(99);
		System.out.println(student.toString());

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);

		List<Student> students = service.getStudents();
		System.out.println(students);

	}

}
