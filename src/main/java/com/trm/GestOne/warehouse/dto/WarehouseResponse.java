package com.trm.GestOne.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponse {
    private Long wareHouseId;

    private String name;
    private Integer capacity;
    private String status;
    private String manager;
}
