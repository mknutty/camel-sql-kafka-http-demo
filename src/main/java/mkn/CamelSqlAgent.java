package mkn;

import org.apache.camel.ProducerTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CamelSqlAgent {
	private final ProducerTemplate producerTemplate;
	
	//Shedlock annotation will be added here
	@Scheduled(initialDelay=60000, fixedRate=30000) //milliseconds
	public void initializeProcess() {
		producerTemplate.sendBody(CamelSqlRouteBuilder.DIRECT_QUERY, "");
	}
	
}
