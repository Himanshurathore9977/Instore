package com.pp.models;

import lombok.*;

import javax.persistence.*;

@Entity(name = "store")
@Table(name = "store", uniqueConstraints = { @UniqueConstraint(columnNames = { "storeName", "countryISO" }) })
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Store extends CreatedDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeID")
    private Long  storeID;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "location")
    private String location;

    @Column(name = "city")
    private String city;

    @Column(name = "countryISO", length = 3)
    private String countryISO;

    @Column(name = "about")
    private String about;

    @Column(name = "activeStore")
    private boolean activeStore;

    @Column(name = "merchantID", nullable = false)
    private long merchantID;
}