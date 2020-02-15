package com.example.demo.controller;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.GenericTypeResolver;

//@Service
public class Chamada<T> {

  RestTemplate restTemplate = new RestTemplate();
  private Class<T> persistentClass;

  public Chamada(Class<T> clazz){
      persistentClass = clazz;
  }

  @Async
  public CompletableFuture<T> testeAsync(long time) throws InterruptedException {
    final String url = String.format("http://localhost:1002/teste");

    T results = restTemplate.getForObject(url, persistentClass);
   
    // Artificial delay of 1s for demonstration purposes
    Thread.sleep(time);
    return CompletableFuture.completedFuture(results);
    //return null;
  }

  public T getTesteWithModel() {

    final String url = String.format("http://localhost:1002/teste");

    final T results = restTemplate.getForObject(url, persistentClass);
    final T testeResults = (T) results;

    // return CompletableFuture.completedFuture(results);
    return testeResults;
  }
}