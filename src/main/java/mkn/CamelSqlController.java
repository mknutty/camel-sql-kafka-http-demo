package mkn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//This emulates the call to hosted.
@RestController
@Slf4j
public class CamelSqlController {
	
	@GetMapping("process")
	public String process(@RequestParam final Long accountId) {
		log.info("Processing Account ", accountId);
		return "Processed Account " + accountId;
	}
}
