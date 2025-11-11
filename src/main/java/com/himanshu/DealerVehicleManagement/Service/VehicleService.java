package com.himanshu.DealerVehicleManagement.Service;

import com.himanshu.DealerVehicleManagement.Entity.Vehicle;
import com.himanshu.DealerVehicleManagement.ExceptionHandling.ResourceNotFoundException;
import com.himanshu.DealerVehicleManagement.Repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);

    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id){
        return vehicleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Vehicle not found"));
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle){
        Vehicle vehicle1=getVehicleById(id);
        vehicle1.setModel(vehicle.getModel());
        vehicle1.setPrice(vehicle.getPrice());
        vehicle1.setDealer(vehicle.getDealer());
        vehicle1.setVehicleStatus(vehicle.getVehicleStatus());

        return vehicleRepository.save(vehicle1);
    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getVehiclesOfPremiumDealers(){
        return vehicleRepository.findAllByPremiumDealers();
    }


}
