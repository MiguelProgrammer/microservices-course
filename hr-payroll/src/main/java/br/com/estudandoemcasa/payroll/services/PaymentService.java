package br.com.estudandoemcasa.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import br.com.estudandoemcasa.payroll.entities.Payment;
import br.com.estudandoemcasa.payroll.entities.Worker;
import br.com.estudandoemcasa.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDayInCome(), days);

	}
}
