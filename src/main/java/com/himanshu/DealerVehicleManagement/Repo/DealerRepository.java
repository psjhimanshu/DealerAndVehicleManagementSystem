package com.himanshu.DealerVehicleManagement.Repo;

import com.himanshu.DealerVehicleManagement.Entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer,Long> {
}
