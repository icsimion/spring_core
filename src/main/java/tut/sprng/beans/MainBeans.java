package tut.sprng.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeans {

	public static void main(String[] args) {
		System.out.println("============= START ============");

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		System.out.println("============= CONTEXT IS UP============");

//		PetService petService = (PetService) context.getBean("petService");
//		petService.viewDetails();
//
//		System.out.println("=========");
//
//		Activity activity = (Activity) context.getBean("activity");
//		activity.viewDetails();

		System.out.println("============= CONTEXT Shutdown ============");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				((ClassPathXmlApplicationContext)context).close();
			}
		});
	}
}
