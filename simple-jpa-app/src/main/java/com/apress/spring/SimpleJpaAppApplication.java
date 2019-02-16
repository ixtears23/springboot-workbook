package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.service.JournalService;

@SpringBootApplication
public class SimpleJpaAppApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SimpleJpaAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start (JournalService service) {
		return args -> {
			log.info("@@ 데이터 생성....");
			// service.insertData() 로 data 생성시 아래 주석 해제하고
			// resources/data.sql 파일을 data.sql.back file로 변경해서 해당 파일이 실행되지 않게 하세요.
//			service.insertData();
			log.info("@@ findAll() 호출...");
			service.findAll().forEach(entry -> log.info(entry.toString()));
			log.info("@@ findCustom() 호출...");
			service.findCustom("프로젝트").forEach(entry -> log.info(entry.toString()));
		};
	}

}

