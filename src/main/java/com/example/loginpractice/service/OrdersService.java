package com.example.loginpractice.service;

import com.example.loginpractice.model.OrdersDto;
import com.example.loginpractice.model.Orders;
import com.example.loginpractice.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void createOrders(OrdersDto orderDto) {
        ordersRepository.save(Orders.builder()
                .member(orderDto.getMember())
                .product(orderDto.getProduct())
                .build());
    }

    public OrdersDto findOrdersById(Integer id) {
        Optional<Orders> result = ordersRepository.findById(id);
        if (result.isPresent()) {
            Orders orders = result.get();

            return OrdersDto.builder()
                    .id(orders.getId())
                    .member(orders.getMember())
                    .product(orders.getProduct())
                    .build();
        } else {
            return null;
        }
    }

    public List<OrdersDto> findOrdersList() {
        List<Orders> result = ordersRepository.findAll();
        List<OrdersDto> ordersDtoList = new ArrayList<>();

        if (!result.isEmpty()) {
            for (Orders orders : result) {
                OrdersDto ordersDto = OrdersDto.builder()
                        .member(orders.getMember())
                        .product(orders.getProduct())
                        .build();
                ordersDtoList.add(ordersDto);
            }
            return ordersDtoList;
        } else {
            return null;
        }
    }

    public void updateOrders(OrdersDto ordersDto) {
        Optional<Orders> result = ordersRepository.findById(ordersDto.getId());
        if (result.isPresent()) {
            Orders orders = result.get();
            orders.setMember(ordersDto.getMember());
            orders.setProduct(ordersDto.getProduct());
            ordersRepository.save(orders);
        }
    }

    public void deleteOrders(Integer id) {
        ordersRepository.delete(Orders.builder().id(id).build());
    }
}
