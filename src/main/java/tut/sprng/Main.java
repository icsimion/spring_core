package tut.sprng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tut.sprng.beans.Transaction;

public class Main {
	
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

      System.out.println("Spring context started");
      System.out.println("======================");
      Transaction transaction = (Transaction) context.getBean("transaction");
      transaction.viewDetails();

   }
}
