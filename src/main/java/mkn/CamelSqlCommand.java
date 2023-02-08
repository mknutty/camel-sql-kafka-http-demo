package mkn;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// The Camel SQL component will use all caps for the column names which will get 
// converted to non-standard JSON so JsonProperty is need to properly deserialize the fields.
@Data
public class CamelSqlCommand {
	
	@JsonProperty("ID")
	private Long id;
	
	@JsonProperty("NAME")
	private String name;
	
}
