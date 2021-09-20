package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Person;

public class DemoApplication {
	public static void main(String[] args) throws IOException {
		String data = Files.readString(Paths.get("src/main/resources/data.txt"));
		var session = getCurrentSessionFromConfig();
		session.beginTransaction();
		data.lines().forEach((str) -> {
			String[] temp = str.split(",");
			Person p = new Person(
				temp[0], 
				Integer.valueOf(temp[1]), 
				Integer.valueOf(temp[2]), 
				temp[3].charAt(0)
			);
			session.save(p);
		});
		session.getTransaction().commit();
		session.close();
	}
	public static Session getCurrentSessionFromConfig() {
		  Configuration config = new Configuration();
		  config.configure();
		  SessionFactory sessionFactory = config.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  return session;
	}
}
