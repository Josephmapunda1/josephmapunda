package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface ProductRepository extends JpaRepository<Product,Long> {
    //all crud method for database
}
