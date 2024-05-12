package co.edu.unisabana.rabbit.springbootrabbitmq.dto;

import lombok.Data;

@Data
public class CafeOrder {
    private int orderId;
    private String orderName;
    private int orderPrice;
}
