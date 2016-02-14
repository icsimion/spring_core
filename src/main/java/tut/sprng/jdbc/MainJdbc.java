package tut.sprng.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tut.sprng.jdbc.student.Student;
import tut.sprng.jdbc.student.StudentJDBCTemplate;
import tut.sprng.jdbc.specialization.Specialization;
import tut.sprng.jdbc.specialization.SpecializationJDBCTemplate;

import java.util.List;

public class MainJdbc {
	private static StudentJDBCTemplate studentJDBCTemplate;
	private static SpecializationJDBCTemplate specializationJDBCTemplate;

	public static void main(String[] args) {
		init();

		// specializations
		createSpecializations();
		getSpecializations();
		deleteSpecializations(new int[]{2, 3, 4, 5});
		updateSpecializations(1);
		getSpecialization(1);
		deleteSpecializations(new int[]{1});


		// students
		createSpecializations();
		List<Specialization> specializations = getSpecializations();

		createStudents(specializations);
		getStudents();
		deleteStudents(new int[]{11, 12, 13});
		updateStudents(14);
		getStudents(14);
		deleteStudents(new int[]{14});

		//clean up
		deleteSpecializations(new int[]{1, 2, 3, 4, 5});

	}


	private static void init() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("application-context.xml");
		studentJDBCTemplate =
				(StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		specializationJDBCTemplate =
				(SpecializationJDBCTemplate) context.getBean("specializationJDBCTemplate");

	}

	private static void createSpecializations() {
		System.out.println("------Specializations create--------");
		specializationJDBCTemplate.create(1, "FrontEnd", "front End Arhitecture");
		specializationJDBCTemplate.create(2, "BackEnd", "Back End Arhitecture");
		specializationJDBCTemplate.create(3, "Security", "Securing apps");
		specializationJDBCTemplate.create(4, "Protocols", "Designing protocols");
		specializationJDBCTemplate.create(5, "Arhitecture", "Arhitecture");
	}

	private static void deleteSpecializations(int[] ids) {
		System.out.println("------Specializations delete--------");
		for (int id : ids) {
			specializationJDBCTemplate.delete(id);
		}
	}

	private static void updateSpecializations(int id) {
		System.out.println("------Specializations update--------");
		specializationJDBCTemplate.update(id, "new description for id = " + id);
	}

	private static Specialization getSpecialization(int id) {
		System.out.println("------Specializations get by id--------");
		Specialization specialization = specializationJDBCTemplate.getSpecialization(id);
		System.out.println(specialization.getId() + " " + specialization.getName());
		return specialization;
	}

	private static List<Specialization> getSpecializations() {
		System.out.println("------Specializations getSpecializations--------");
		List<Specialization> specializations = specializationJDBCTemplate.listSpecializations();
		for (Specialization specialization : specializations) {
			System.out.println(specialization.getId() + " " + specialization.getName());
		}
		return specializations;
	}

	private static void createStudents(List<Specialization> specializations) {
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create(11, "Hulya", 25, 99, specializations.get((int) (specializations.size() * Math.random())));
		studentJDBCTemplate.create(12, "Ilie", 27, 89, specializations.get((int) (specializations.size() * Math.random())));
		studentJDBCTemplate.create(13, "Calin", 25, 76, specializations.get((int) (specializations.size() * Math.random())));
		studentJDBCTemplate.create(14, "Alina", 80, 100, specializations.get((int) (specializations.size() * Math.random())));
	}

	private static void deleteStudents(int[] ids) {
		System.out.println("------Students delete--------");
		for (int id : ids) {
			studentJDBCTemplate.delete(id);
		}
	}

	private static void updateStudents(int id) {
		System.out.println("------Students update--------");
		studentJDBCTemplate.update(id, 20 + id);
	}

	private static Student getStudents(int id) {
		System.out.println("------Students get by id--------");
		Student student = studentJDBCTemplate.getStudent(id);
		System.out.println(student.getId() + " " + student.getName());
		return student;
	}

	private static List<Student> getStudents() {
		System.out.println("------Students getStudents--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student student : students) {
			System.out.println(student.getId() + " " + student.getName());
		}
		return students;
	}

}
