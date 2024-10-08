package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;

import java.util.List;

public interface CustomerOrderService {
    CustomerOrder createCustomerOrder(String customerEmail, String customerAddress, List<OrderItem> items);
    void addOrderItem(Long CustomerOrderId, OrderItem item);
    void removeOrderItem(Long CustomerOrderId, OrderItem item);
    void sendCustomerOrderForDelivery(Long CustomerOrderId);
    CustomerOrder findCustomerOrderById(Long CustomerOrderId);
    void updateCustomerOrderDeliveryStatus(Long CustomerOrderId, String status);
}
