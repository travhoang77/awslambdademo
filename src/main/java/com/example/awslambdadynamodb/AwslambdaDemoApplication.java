package com.example.awslambdadynamodb;

import com.example.awslambdadynamodb.functions.Createuserfunction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;



@SpringBootApplication
public class AwslambdaDemoApplication implements ApplicationContextInitializer<GenericApplicationContext> {


	@Override
	public void initialize(GenericApplicationContext context) {
		context.registerBean("createuserfunction", FunctionRegistration.class, () -> new FunctionRegistration<>(new Createuserfunction()).type(Createuserfunction.class));
	}

	public static void main(String[] args) {
		FunctionalSpringApplication.run(AwslambdaDemoApplication.class, args);
	}
}

