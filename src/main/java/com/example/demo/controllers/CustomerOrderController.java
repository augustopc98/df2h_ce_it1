package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;
import com.example.demo.services.CustomerOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CustomerOrders")
public class CustomerOrderController {

    private final CustomerOrderService CustomerOrderService;

    public CustomerOrderController(CustomerOrderService CustomerOrderService) {
        this.CustomerOrderService = CustomerOrderService;
    }

    @PostMapping
    public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder CustomerOrder) {
        return CustomerOrderService.createCustomerOrder(CustomerOrder.getCustomerEmail(), CustomerOrder.getCustomerAddress(), CustomerOrder.getItems());
    }

    @PutMapping("/{CustomerOrderId}/items")
    public void addOrderItem(@PathVariable Long CustomerOrderId, @RequestBody OrderItem item) {
        CustomerOrderService.addOrderItem(CustomerOrderId, item);
    }

    @DeleteMapping("/{CustomerOrderId}/items")
    public void removeOrderItem(@PathVariable Long CustomerOrderId, @RequestBody OrderItem item) {
        CustomerOrderService.removeOrderItem(CustomerOrderId, item);
    }

    @PutMapping("/{CustomerOrderId}/sendForDelivery")
    public void sendCustomerOrderForDelivery(@PathVariable Long CustomerOrderId) {
        CustomerOrderService.sendCustomerOrderForDelivery(CustomerOrderId);
    }

    @GetMapping("/{CustomerOrderId}")
    public CustomerOrder findCustomerOrderById(@PathVariable Long CustomerOrderId) {
        return CustomerOrderService.findCustomerOrderById(CustomerOrderId);
    }

    @PutMapping("/{CustomerOrderId}/status")
    public void updateCustomerOrderDeliveryStatus(@PathVariable Long CustomerOrderId, @RequestParam String status) {
        CustomerOrderService.updateCustomerOrderDeliveryStatus(CustomerOrderId, status);
    }
}
