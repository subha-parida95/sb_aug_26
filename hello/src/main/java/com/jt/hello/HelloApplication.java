package com.jt.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

@ImportResource("beans.xml")
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(HelloApplication.class, args);
		// 1. Using xml file
		Greet g = context.getBean(Greet.class);
		g.sayHello();

		// 2. Using stereotype annotation
		Person person = context.getBean(Person.class);
		person.sayHello();

		// 3. Using Configurable file
		Student student = context.getBean(Student.class);
		student.sayHello();

		Teacher teacher = context.getBean(Teacher.class);
		teacher.sayHello();

		System.out.println(teacher.hashCode());
		Teacher teacher2 = context.getBean(Teacher.class);
		System.out.println(teacher2.hashCode());

		System.out.println("Student1 "+ student.hashCode());
		Student student2 = context.getBean(Student.class);
		System.out.println("Student2 "+ student2.hashCode());

		System.out.println(g.hashCode());
		Greet g2 = context.getBean(Greet.class);
		System.out.println(g2.hashCode());
	}

}
