package br.com.estudandoemcasa.payroll.services;

import org.springframework.stereotype.Service;

import br.com.estudandoemcasa.payroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		/*
		 * Mock
		 */
		return new Payment("Miguel Silva", 400.00, days);
	}
}
