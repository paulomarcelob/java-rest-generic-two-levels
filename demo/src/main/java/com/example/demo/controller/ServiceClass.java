package com.example.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass extends Model<String> {

  //@Autowired
  private Chamada<ServiceClass> chamada;

  //@Bean
  public ServiceClass() {
    chamada = new Chamada<ServiceClass>(ServiceClass.class);
  }

  public String testeChamada() throws InterruptedException, ExecutionException {

    //ServiceClass teste = chamada.getTesteWithModel();
    //String retorno = teste.getGenerico();

    //https://github.com/karlkyck/spring-boot-completablefuture/tree/master/src/main/java/com/humansreadcode/example

    CompletableFuture<ServiceClass> page1 = chamada.testeAsync(1000L);
    CompletableFuture<ServiceClass> page2 = chamada.testeAsync(10000L);

    // Wait until they are all done
    CompletableFuture.allOf(page1,page2).join();

    String retorno = page1.get().getGenerico();
    // Print results, including elapsed time
    System.out.println(retorno + System.currentTimeMillis());
    System.out.println(page2.get().getGenerico() + System.currentTimeMillis());
    
    return retorno;
  }
}