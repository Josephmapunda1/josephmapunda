package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.Product;
import com.benezeth.MockinApp.exception.ProductException;
import com.benezeth.MockinApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_info")
@SuppressWarnings("ALL")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    //code for getting all user
    @GetMapping
    public List<Product>getAllUser(){
        return productRepository.findAll();
    }
    //code for creating user
    @PostMapping
    public Product createUser(@RequestBody Product product){
        return productRepository.save(product);}
    @GetMapping("{id}")
    public ResponseEntity<Product>getUserById(@PathVariable Long id) {
        Product getUser = productRepository.findById(id).orElseThrow(() -> new ProductException("user does not exist"));
    return ResponseEntity.ok(getUser);}
        @PutMapping("{id}")
                public ResponseEntity<Product>UpdateUser(@PathVariable Long id,@RequestBody Product UserDetails){
        Product UpdateUser=productRepository.findById(id).orElseThrow(()->new ProductException("user does not exist"));
UpdateUser.setUserId(UserDetails.getUserId());
UpdateUser.setUserAddress(UserDetails.getUserAddress());
UpdateUser.setUserJob(UserDetails.getUserJob());
UpdateUser.setUserName(UserDetails.getUserName());
UpdateUser.setUserPhoneNo(UserDetails.getUserPhoneNo());

productRepository.save(UpdateUser);
return ResponseEntity.ok(UpdateUser);
    }
   // code for deleting
    @DeleteMapping("{id}")
    public ResponseEntity<Product>deleteUser(long id){
        Product user=productRepository.findById(id).orElseThrow(()->new ProductException("user does not exist"));
        productRepository.delete(user);
        return ResponseEntity.ok(user);
    }

}
