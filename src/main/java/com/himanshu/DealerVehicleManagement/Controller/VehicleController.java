package com.himanshu.DealerVehicleManagement.Controller;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.himanshu.DealerVehicleManagement.Entity.Vehicle;
import com.himanshu.DealerVehicleManagement.Service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {


    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService=vehicleService;
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicle(){
        return vehicleService.getAllVehicle();
    }
@GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id){
    return vehicleService.getVehicleById(id);
}

@PutMapping("/{id}")
public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return  vehicleService.updateVehicle(id,vehicle);
}

@DeleteMapping("/{id}")
public void deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
}

@GetMapping("/premiumDealers")
public List<Vehicle> getVehicleOfPremiumDealers(){
        return vehicleService.getVehiclesOfPremiumDealers();
}
}
