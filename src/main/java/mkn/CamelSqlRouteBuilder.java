package mkn;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class CamelSqlRouteBuilder extends RouteBuilder {
	private static final String KAFKA_COMMAND_TOPIC = "kafka:command.topic";
	public static final String DIRECT_QUERY = "direct:query";

	@Override
	public void configure() throws Exception {
		from(DIRECT_QUERY).routeId("query-route")
			.to("sql:select * from account")
			.split(body()).id("split-records")
				.marshal().json(JsonLibrary.Jackson).id("convert-map-to-json")
				.log("${body}")
				.to(KAFKA_COMMAND_TOPIC);
		
		from(KAFKA_COMMAND_TOPIC).routeId("process-route")
			.unmarshal().json(JsonLibrary.Jackson, CamelSqlCommand.class).id("convert-to-pojo")
			.log("from kafka ${body}")
			.setHeader(Exchange.HTTP_QUERY, simple("accountId=${body.id}"))
			.to("http://localhost:8080/process")
			.log("${body}").id("log-request-result");

	}

}
