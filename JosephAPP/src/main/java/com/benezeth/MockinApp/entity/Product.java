package com.benezeth.MockinApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_info")
@SuppressWarnings("ALL")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="UserId")
    int UserId;

    @Column(name="UserName")
    String UserName;
    @Column(name="UserAddress")
    String UserAddress;
    @Column(name="UserPhoneNo")
    String UserPhoneNo;
    @Column(name="UserJob")
    String UserJob;

}
