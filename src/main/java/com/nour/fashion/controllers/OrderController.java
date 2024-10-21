package com.nour.fashion.controllers;


import com.nour.fashion.entities.Order;
import com.nour.fashion.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Order API")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Operation(summary = "Returns order list ", description = "Returns order list ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the order list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class))})

    })
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @Operation(summary = "Returns order by Id ", description = "Returns order by Id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find order by Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class))})

    })
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @Operation(summary = "Add order", description = "Add order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "order added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class))})

    })
    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @Operation(summary = "Delete order by id", description = "Delete order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class))})

    })
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
