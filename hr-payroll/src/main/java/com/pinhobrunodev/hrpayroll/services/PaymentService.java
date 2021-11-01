package com.pinhobrunodev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhobrunodev.hrpayroll.entities.Payment;
import com.pinhobrunodev.hrpayroll.entities.Worker;
import com.pinhobrunodev.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {


	@Autowired
	private WorkerFeignClient workerFeignClient;

	@Autowired
	ObjectMapper mapper;

	// a partir do workerId que eu passar , vou precisar chamar ele la do hr-worker
	public Payment getPayment(Long workerId, int days) {
		
		// Pega o corpo da resposta do worker que foi encontrado pelo ID
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
