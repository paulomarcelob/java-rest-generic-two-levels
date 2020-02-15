package com.example.demo.controller;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

	@Autowired
	ServiceClass service;

	// public static Class<?> findSuperClassParameterType(Object instance, Class<?>
	// classOfInterest, int parameterIndex) {
	// Class<?> subClass = instance.getClass();
	// while (subClass != subClass.getSuperclass()) {
	// // instance.getClass() is no subclass of classOfInterest or instance is a
	// direct instance of classOfInterest
	// subClass = subClass.getSuperclass();
	// if (subClass == null) throw new IllegalArgumentException();
	// }
	// ParameterizedType parameterizedType = (ParameterizedType)
	// subClass.getGenericSuperclass();
	// return (Class<?>) parameterizedType.getActualTypeArguments()[parameterIndex];
	// }

	// public TestController(){
	// Class<?> teste2 = findSuperClassParameterType(new Model<String>(),
	// Model.class, 0);
	// service = new ServiceClass<ModelDto>(ModelDto.class);
	// }

	@GetMapping("/teste")
	public ResponseEntity<String> get() throws InterruptedException, ExecutionException {

        String retorno = service.testeChamada();

		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
}