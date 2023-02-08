package mkn;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CamelSqlApplicationRunner implements ApplicationRunner {
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(final ApplicationArguments args) throws Exception {
		jdbcTemplate.execute("create table account(id INT NOT NULL, name varchar(1000))");
		jdbcTemplate.execute("insert into account(id, name) values (1, 'account1')");
		jdbcTemplate.execute("insert into account(id, name) values (2, 'account2')");
		
		jdbcTemplate.queryForList("select * from account").forEach(System.out::println);
	}

}
