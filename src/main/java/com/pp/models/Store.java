package com.pp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Store", uniqueConstraints = { @UniqueConstraint(columnNames = { "storeName", "countryISO" }) })
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store extends CreatedDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeID")
    private int storeID;

    @Column(name = "storeName" , unique = true)
    private String storeName;

    @Column(name = "location")
    private String location;

    @Column(name = "city")
    private String city;

    @Column(name = "countryISO")
    private String countryISO;

    @Column(name = "about")
    private String about;

    @Column(name = "activeStore")
    private boolean activeStore;

    @Column(name = "merchantID", nullable = false)
    private long merchantID;
}