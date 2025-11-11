package com.himanshu.DealerVehicleManagement.Service;

import com.himanshu.DealerVehicleManagement.Entity.Payment;
import com.himanshu.DealerVehicleManagement.Repo.PaymentRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

import static org.hibernate.action.internal.BulkOperationCleanupAction.schedule;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    public Payment createPayment(Long dealerId, Double amount, String method){
        Payment payment=new Payment();
        payment.setDealerId(dealerId);
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus("PENDING");

        Payment savedPayment=paymentRepository.save(payment);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            savedPayment.setStatus("SUCCESS");
            paymentRepository.save(savedPayment);
            System.out.println("Payment ID " +savedPayment.getId()+" marked as SUCCESS");
        }, 5, TimeUnit.SECONDS);
        return savedPayment;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
