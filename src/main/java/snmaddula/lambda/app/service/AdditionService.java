package snmaddula.lambda.app.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import snmaddula.lambda.app.domain.Input;
import snmaddula.lambda.app.domain.Output;

@Slf4j
@Service
public class AdditionService {

	public Output add(Input input) {
		
		log.info("INPUT VALUES = {}", input.getValues());
		
		int result = input.getValues().stream().mapToInt(Integer::intValue).sum();
		
		log.info("ADDITION RESULT = {}", result);
		
		return new Output(input.getValues(), result);
	}
}
