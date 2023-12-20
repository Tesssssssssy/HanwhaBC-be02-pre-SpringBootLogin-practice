package com.example.loginpractice.controller;

import com.example.loginpractice.model.OrdersDto;
import com.example.loginpractice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService orderService;

    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createOrders(OrdersDto ordersDto) {
        orderService.createOrders(ordersDto);
        return ResponseEntity.ok().body("Orders 생성 완료");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity findOrdersById(Integer id) {
        OrdersDto ordersDto = orderService.findOrdersById(id);
        return ResponseEntity.ok().body(ordersDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity findOrdersList() {
        List<OrdersDto> ordersDtoList = orderService.findOrdersList();
        return ResponseEntity.ok().body(ordersDtoList);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateOrders(OrdersDto ordersDto) {
        orderService.updateOrders(ordersDto);
        return ResponseEntity.ok().body("Orders 수정 완료");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteOrders(Integer id) {
        orderService.deleteOrders(id);
        return ResponseEntity.ok().body("Orders 삭제 완료");
    }
}
