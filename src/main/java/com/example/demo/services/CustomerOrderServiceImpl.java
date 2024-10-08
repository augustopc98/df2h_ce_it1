package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;
import com.example.demo.repositories.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository CustomerOrderRepository;

    public CustomerOrderServiceImpl(CustomerOrderRepository CustomerOrderRepository) {
        this.CustomerOrderRepository = CustomerOrderRepository;
    }

    @Override
    public CustomerOrder createCustomerOrder(String customerEmail, String customerAddress, List<OrderItem> items) {
        CustomerOrder CustomerOrder = new CustomerOrder(customerEmail, customerAddress, new Date());
        for (OrderItem item : items) {
            CustomerOrder.addOrderItem(item);
        }
        return CustomerOrderRepository.save(CustomerOrder);
    }

    @Override
    public void addOrderItem(Long CustomerOrderId, OrderItem item) {
        CustomerOrder CustomerOrder = findCustomerOrderById(CustomerOrderId);
        CustomerOrder.addOrderItem(item);
        CustomerOrderRepository.save(CustomerOrder);
    }

    @Override
    public void removeOrderItem(Long CustomerOrderId, OrderItem item) {
        CustomerOrder CustomerOrder = findCustomerOrderById(CustomerOrderId);
        CustomerOrder.removeOrderItem(item);
        CustomerOrderRepository.save(CustomerOrder);
    }

    @Override
    public void sendCustomerOrderForDelivery(Long CustomerOrderId) {
        CustomerOrder CustomerOrder = findCustomerOrderById(CustomerOrderId);
        CustomerOrder.sendForDelivery();
        CustomerOrderRepository.save(CustomerOrder);
    }

    @Override
    public CustomerOrder findCustomerOrderById(Long CustomerOrderId) {
        Optional<CustomerOrder> CustomerOrder = CustomerOrderRepository.findById(CustomerOrderId);
        return CustomerOrder.orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
    }

    @Override
    public void updateCustomerOrderDeliveryStatus(Long CustomerOrderId, String status) {
        CustomerOrder CustomerOrder = findCustomerOrderById(CustomerOrderId);
        CustomerOrder.setDeliveryStatus(status);
        CustomerOrderRepository.save(CustomerOrder);
    }
}
