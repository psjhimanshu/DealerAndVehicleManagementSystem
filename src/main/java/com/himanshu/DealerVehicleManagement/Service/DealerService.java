package com.himanshu.DealerVehicleManagement.Service;

import com.himanshu.DealerVehicleManagement.Entity.Dealer;
import com.himanshu.DealerVehicleManagement.ExceptionHandling.ResourceNotFoundException;
import com.himanshu.DealerVehicleManagement.Repo.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository){
        this.dealerRepository=dealerRepository;
    }

    public Dealer createDealer(Dealer dealer){
        return dealerRepository.save(dealer);
    }

    public List<Dealer> getAllDealer(){
        return dealerRepository.findAll();
    }

    public Dealer getDealerById(Long id){
        return dealerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Dealer Id Not found"));
    }

    public Dealer updateDealer(Long id, Dealer dealer){
        Dealer dealer1=getDealerById(id);
        dealer1.setName(dealer.getName());
        dealer1.setEmail(dealer.getEmail());
        dealer1.setSubscriptionType(dealer.getSubscriptionType());

        return dealerRepository.save(dealer1);

    }

    public void deleteDealer(Long id){
        if (id == null) {
            throw new IllegalArgumentException("Dealer ID cannot be null for delete operation");
        }
        dealerRepository.deleteById(id);
    }
}
