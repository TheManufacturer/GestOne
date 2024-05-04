package com.trm.GestOne.warehouse;

import com.trm.GestOne.warehouse.dto.WarehouseRequest;
import com.trm.GestOne.warehouse.dto.WarehouseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseModel {
    private Long wareHouseId;

    private String name;
    private Integer capacity;
    private String status;
    private String manager;

    //Entity to Model
    public static WarehouseModel mapEntityToModel(Warehouse warehouse) {
        return new WarehouseModel(
                warehouse.getWareHouseId(),
                warehouse.getName(),
                warehouse.getCapacity(),
                warehouse.getStatus(),
                warehouse.getManager()
        );
    }

    //Model to Entity
    public static Warehouse mapModelToEntity(WarehouseModel warehouseModel) {
        return new Warehouse(
                warehouseModel.getWareHouseId(),
                warehouseModel.getName(),
                warehouseModel.getCapacity(),
                warehouseModel.getStatus(),
                warehouseModel.getManager()
        );
    }

    //Model to Response
    public static WarehouseResponse mapModelToResponse(WarehouseModel warehouseModel) {
        return new WarehouseResponse(
                warehouseModel.getWareHouseId(),
                warehouseModel.getName(),
                warehouseModel.getCapacity(),
                warehouseModel.getStatus(),
                warehouseModel.getManager()
        );
    }

    //Model to Request
    public static WarehouseModel mapRequestToModel(WarehouseRequest warehouseRequest) {
        return new WarehouseModel(
                null,
                warehouseRequest.getName(),
                warehouseRequest.getCapacity(),
                warehouseRequest.getStatus(),
                warehouseRequest.getManager()
        );
    }
}
