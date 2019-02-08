package snmaddula.lambda.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import snmaddula.lambda.app.domain.Employee;
import snmaddula.lambda.app.dto.Output;

/**
 * 
 * @author snmaddula
 *
 */
@Service
public class EmployeeService {

	private static final Map<Long, Employee> EMPLOYEES = new HashMap<>();

	@PostConstruct
	public void loadSeedData() {
		LongStream
			.rangeClosed(1, 10)
			.forEach(i -> EMPLOYEES.put(i, new Employee(i, "NAME_" + i, "EMAIL_" + i)));
	}

	public Output fetchById(Long id) {
		if (EMPLOYEES.containsKey(id)) {
			return new Output(EMPLOYEES.get(id));
		}
		return new Output("No record found for id: " + id);
	}

	public Output fetchAll() {
		return new Output(EMPLOYEES.values());
	}

}
