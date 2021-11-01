package com.pinhobrunodev.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinhobrunodev.hrpayroll.entities.Payment;
import com.pinhobrunodev.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	// Caso ocorra algum erro na chamada vaia tivar o Hystrix Abaixo
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity.ok().body(service.getPayment(workerId, days));
	}

	// Qual pode ser um caminho alternativo q nao dependa do microservice q esta fora do ar?
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId,Integer days){
		Payment payment = new Payment("Brann",400.00,days);
		return ResponseEntity.ok().body(payment);
	}
}
