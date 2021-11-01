package com.pinhobrunodev.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.pinhobrunodev.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	// a partir do workerId que eu passar , vou precisar chamar ele la no hr-worker
	public Payment getPayment(Long workerId,int days) {
		// Pagamento mockado
		return new Payment("Bob",200.00,days);
	}
}
