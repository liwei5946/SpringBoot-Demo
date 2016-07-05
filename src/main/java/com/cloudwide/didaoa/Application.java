package com.cloudwide.didaoa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application{
	   public static final Logger logger = LoggerFactory.getLogger(Application.class);

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	        logger.info("Springboot Application [springboot-demo-web] started!");
	    }
}