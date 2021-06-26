package com.cg.registrationapp;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RegistrationApp {
	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
		
		//Integer adminId=1234;
		//String password="admin";
		
		//System.out.println("Enter the credentials:");
		
		//System.out.println("Enter AdminId");
		//Integer ipId=sc.nextInt();
		
		//System.out.println("Enter password");
		//String ipPassword=sc.next();
		
		//if(ipId.equals(adminId) && ipPassword.equals(password)) {
		SpringApplication.run(RegistrationApp.class, args);
		
		//System.out.println("------------------SERVER started---------PORT=8067--------------"
			//	+ "");
		//}else {
		//	System.out.println("Try again with valid credentials.....");
		//	System.exit(0);
		//}
	//} 
	}
}
