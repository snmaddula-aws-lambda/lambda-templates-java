package snmaddula.lambda.app;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.event.S3EventNotification.S3Entity;

@SpringBootApplication
public class App extends SpringBootRequestHandler<S3EventNotification , String> {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public Function<S3EventNotification, String> processJsonPayload() {
		return (eventNotification) -> {
			S3Entity s3 = eventNotification.getRecords().get(0).getS3();
			String bucketName = s3.getBucket().getName();
			String objectKey = s3.getObject().getKey();
			System.out.println("-----------------JSON PAYLOAD-----------------------");
			System.out.println("bucketName: " + bucketName);
			System.out.println("objectKey: " + objectKey);
			return "DONE";
		};
	}

	@Bean
	public Function<S3EventNotification, String> processXMLPayload() {
		return (eventNotification) -> {
			S3Entity s3 = eventNotification.getRecords().get(0).getS3();
			String bucketName = s3.getBucket().getName();
			String objectKey = s3.getObject().getKey();
			
			System.out.println("------------------XML PAYLOAD-----------------------");
			System.out.println("bucketName: " + bucketName);
			System.out.println("objectKey: " + objectKey);
			return "DONE";
		};
	}
}
