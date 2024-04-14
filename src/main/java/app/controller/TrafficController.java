package app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 메트릭 스트레스 수치 테스트를위한 트레
 */
@Slf4j
@RestController
public class TrafficController {
	
	private List<String> list = new ArrayList<>();
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/cpu")
	public String cpu() {
		log.info("cpu");
		long value = 0L;
		for (long i = 0; i < 100_000_000_000L; i++) {
			value++;
		}
		return "result value: " + value;
	}
	
	@GetMapping("/jvm")
	public String jvm() {
		log.info("jvm");
		for (long i = 0; i < 1_000_000L; i++) {
			list.add("hello jvm : " + i);
		}
		return "jvm ok";
	}
	
	@GetMapping("/jdbc")
	public String jdbc() throws SQLException {
		log.info("jdbc");
		Connection connection = dataSource.getConnection();
		log.info("connection: {}", connection);
		// JDBC close를 하지 않음
		return "jdbc ok";
	}
}