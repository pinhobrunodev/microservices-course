package com.pinhobrunodev.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pinhobrunodev.hrpayroll.entities.Worker;

@Component
// nome do microservice e parametros hard-code
@FeignClient(name = "hr-worker",url = "localhost:8001",path = "/workers")
public interface WorkerFeignClient {

	// Essa interface declara os tipos de chamadas de Web Service que irei fazer
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
	
}
