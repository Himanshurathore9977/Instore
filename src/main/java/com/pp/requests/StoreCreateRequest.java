package com.pp.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreCreateRequest {

    @NotBlank(message = "Please provide store name ")
    private String storeName;

    private String location;

    private String city;

    private String countryISO;

    private String about;

    private boolean activeStore;

    @NotNull(message = "Please provide merchant Id ")
    private long merchantID;

}
