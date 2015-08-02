package tut.sprng.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeans {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		System.out.println("-------");

		Quest quest = (Quest) context.getBean("quest");
		quest.viewDetails();

		System.out.println("-------");

		HeroService heroService = (HeroService) context.getBean("heroService");
		heroService.viewDetails();

		System.out.println("-------");

		System.out.println("--- Shutdown context ---");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				((ClassPathXmlApplicationContext)context).close();
			}
		});
	}
}
