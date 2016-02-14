package tut.sprng.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeans {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		System.out.println("-------");

		Activity activity = (Activity) context.getBean("activity");
		activity.viewDetails();

		System.out.println("-------");

		PetService petService = (PetService) context.getBean("petService");
		petService.viewDetails();

		System.out.println("-------");

		System.out.println("--- Shutdown context ---");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				((ClassPathXmlApplicationContext)context).close();
			}
		});
	}
}
