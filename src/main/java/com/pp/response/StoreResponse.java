package com.pp.response;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private String storeName;
    private String location;
    private String city;
    private String countryISO;
    private String about;
    private boolean activeStore;
    private long merchantID;

}
