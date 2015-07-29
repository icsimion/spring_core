package tut.sprng.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        GraduateJDBCTemplate graduateJDBCTemplate =
                (GraduateJDBCTemplate)context.getBean("graduateJDBCTemplate");

        System.out.println("------Records Creation--------" );
        graduateJDBCTemplate.create("Zara", 11);
        graduateJDBCTemplate.create("Nuha", 2);
        graduateJDBCTemplate.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------" );
        List<Graduate> graduates = graduateJDBCTemplate.listGraduates();
        for (Graduate record : graduates) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        graduateJDBCTemplate.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----" );
        Graduate graduate = graduateJDBCTemplate.getGraduate(2);
        System.out.print("ID : " + graduate.getId() );
        System.out.print(", Name : " + graduate.getName() );
        System.out.println(", Age : " + graduate.getAge());

    }
}
