# Spring Cloud AWS Lambda Template
AWS Lambda Function bootstrapped with Spring Boot + Spring Cloud runtime.

##### Package App
    mvn clean package
    
##### Invoke the App
	java -jar target/lambda-template-1.0-aws.jar

##### Invoke Endpoint : uppercase
    curl -H "Content-Type: text/plain" localhost:8080/uppercase -d 'HelloWorld'

##### Response:
	HELLOWORLD



	
	