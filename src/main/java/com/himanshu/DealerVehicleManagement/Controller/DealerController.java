package com.himanshu.DealerVehicleManagement.Controller;

import com.himanshu.DealerVehicleManagement.Entity.Dealer;
import com.himanshu.DealerVehicleManagement.Service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealer")
public class DealerController {

    private DealerService dealerService;

    public DealerController(DealerService dealerService){

        this.dealerService=dealerService;
    }

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer){
        return dealerService.createDealer(dealer);
    }

    @GetMapping
    public List<Dealer> getAllDealer(){
        return dealerService.getAllDealer();
    }

    @GetMapping("/{id}")
    public Dealer getDealerById(@PathVariable Long id){
    return dealerService.getDealerById(id);
    }

    @PutMapping("/{id}")
    public Dealer updateDealer(@PathVariable Long id, @RequestBody Dealer dealer){
        return dealerService.updateDealer(id,dealer);
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id){
        dealerService.deleteDealer(id);
        return ResponseEntity.noContent().build();
    }



}
