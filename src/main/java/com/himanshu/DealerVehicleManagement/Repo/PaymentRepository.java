package com.himanshu.DealerVehicleManagement.Repo;

import com.himanshu.DealerVehicleManagement.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
