package com.himanshu.DealerVehicleManagement.Repo;

import com.himanshu.DealerVehicleManagement.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = com.himanshu.DealerVehicleManagement.Enum.SubscriptionType.PREMIUM")
    List<Vehicle> findAllByPremiumDealers();
}
