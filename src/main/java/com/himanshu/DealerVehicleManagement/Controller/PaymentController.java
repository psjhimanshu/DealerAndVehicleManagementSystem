package com.himanshu.DealerVehicleManagement.Controller;

import com.himanshu.DealerVehicleManagement.Entity.Payment;
import com.himanshu.DealerVehicleManagement.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this. paymentService=paymentService;
    }

    @PostMapping("/create")
//    public Payment createPayment(@RequestParam Long dealerId,
//                                 @RequestParam Double amount,
//                                 @RequestParam String method){
//        return paymentService.createPayment(dealerId, amount,method);
//    }
    public Payment createPayment(@RequestBody Payment paymentRequest) {
        return paymentService.createPayment(
                paymentRequest.getDealerId(),
                paymentRequest.getAmount(),
                paymentRequest.getMethod()
        );
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

}
