package com.ang.spring.projet;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication

public class ProjetApplication {

	public static void main(String[] args) throws JRException
	{
		SpringApplication.run(ProjetApplication.class, args);

	}

}
