package snmaddula.lambda.app;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;

import snmaddula.lambda.app.domain.Input;
import snmaddula.lambda.app.domain.Output;
import snmaddula.lambda.app.service.AdditionService;

@SpringBootApplication
public class App extends SpringBootRequestHandler<Input, Output> {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * This function takes a list of integers and calculates the sum of all the
	 * integers.
	 */
	@Bean
	public Function<Input, Output> add(AdditionService additionService) {
		return (input) -> additionService.add(input);
	}
}
