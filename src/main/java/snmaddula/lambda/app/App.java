package snmaddula.lambda.app;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import snmaddula.lambda.app.dto.Output;
import snmaddula.lambda.app.service.EmployeeService;

/**
 * 
 * @author snmaddula
 *
 */
@SpringBootApplication
public class App extends SpringBootRequestHandler<Map<String, Object>, Output> {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public Function<Map<String, Object>, Output> process(EmployeeService employeeService) {
		return input -> {
			String id = Objects.toString(((Map) input.get("query")).get("id"), null);
			if (StringUtils.hasText(id)) {
				return employeeService.fetchById(Long.valueOf(id));
			} else {
				return employeeService.fetchAll();
			}
		};
	}
}
