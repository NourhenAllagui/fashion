package com.nour.fashion.controllers;

import com.nour.fashion.entities.Customer;
import com.nour.fashion.entities.Product;
import com.nour.fashion.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product API")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Returns product list ", description = "Returns product list ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the product list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))})

    })
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }
    @Operation(summary = "Returns product by Id ", description = "Returns product by Id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find product by Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))})

    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Add product", description = "Add product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))})

    })
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @Operation(summary = "Delete product by id", description = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))})

    })
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
