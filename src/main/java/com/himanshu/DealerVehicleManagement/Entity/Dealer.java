package com.himanshu.DealerVehicleManagement.Entity;

import com.himanshu.DealerVehicleManagement.Enum.SubscriptionType;
import jakarta.persistence.*;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealer_id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    public Dealer() {
    }

    public Dealer(Long id, String name, String email, SubscriptionType subscriptionType) {
        this.dealer_id = id;
        this.name = name;
        this.email = email;
        this.subscriptionType = subscriptionType;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + dealer_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionType=" + subscriptionType +
                '}';
    }

    public Long getId() {
        return dealer_id;
    }

    public void setId(Long id) {
        this.dealer_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
