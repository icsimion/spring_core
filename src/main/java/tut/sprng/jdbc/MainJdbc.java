package tut.sprng.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tut.sprng.jdbc.graduate.Graduate;
import tut.sprng.jdbc.graduate.GraduateJDBCTemplate;
import tut.sprng.jdbc.specialization.Specialization;
import tut.sprng.jdbc.specialization.SpecializationJDBCTemplate;

import java.util.List;

public class MainJdbc {
	private static GraduateJDBCTemplate graduateJDBCTemplate;
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


		// graduates
		createSpecializations();
		List<Specialization> specializations = getSpecializations();

		createGraduates(specializations);
		getGraduates();
		deleteGraduates(new int[]{11, 12, 13});
		updateGraduates(14);
		getGraduates(14);
		deleteGraduates(new int[]{14});

		//clean up
		deleteSpecializations(new int[]{1, 2, 3, 4, 5});

	}


	private static void init() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("application-context.xml");
		graduateJDBCTemplate =
				(GraduateJDBCTemplate) context.getBean("graduateJDBCTemplate");
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

	private static void createGraduates(List<Specialization> specializations) {
		System.out.println("------Records Creation--------");
		graduateJDBCTemplate.create(11, "Hulya", 25, 99, specializations.get((int) (specializations.size() * Math.random())));
		graduateJDBCTemplate.create(12, "Ilie", 27, 89, specializations.get((int) (specializations.size() * Math.random())));
		graduateJDBCTemplate.create(13, "Calin", 25, 76, specializations.get((int) (specializations.size() * Math.random())));
		graduateJDBCTemplate.create(14, "Alina", 80, 100, specializations.get((int) (specializations.size() * Math.random())));
	}

	private static void deleteGraduates(int[] ids) {
		System.out.println("------Graduates delete--------");
		for (int id : ids) {
			graduateJDBCTemplate.delete(id);
		}
	}

	private static void updateGraduates(int id) {
		System.out.println("------Graduates update--------");
		graduateJDBCTemplate.update(id, 20 + id);
	}

	private static Graduate getGraduates(int id) {
		System.out.println("------Graduates get by id--------");
		Graduate graduate = graduateJDBCTemplate.getGraduate(id);
		System.out.println(graduate.getId() + " " + graduate.getName());
		return graduate;
	}

	private static List<Graduate> getGraduates() {
		System.out.println("------Graduates getGraduates--------");
		List<Graduate> graduates = graduateJDBCTemplate.listGraduates();
		for (Graduate graduate : graduates) {
			System.out.println(graduate.getId() + " " + graduate.getName());
		}
		return graduates;
	}

}
