package com.nour.fashion.controllers;


import com.nour.fashion.entities.Customer;
import com.nour.fashion.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customer API")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Returns customer list ", description = "Returns customer list ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the customer list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})

    })
    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Returns customer by Id ", description = "Returns customer by Id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find customer by Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})

    })
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomersById(id);
    }

    @Operation(summary = "Add customer", description = "Add customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "customer added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})

    })
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @Operation(summary = "Delete customer by id", description = "Delete customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})

    })
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
