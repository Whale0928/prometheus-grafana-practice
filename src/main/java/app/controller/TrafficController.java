package app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 메트릭 스트레스 수치 테스트를위한 트레
 */
@Slf4j
@RestController
public class TrafficController {
	
	@GetMapping("/cpu")
	public String cpu() {
		log.info("cpu");
		long value = 0L;
		return "cpu";
	}
}