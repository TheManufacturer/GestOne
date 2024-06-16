package com.trm.GestOne.item.ItemDto;

import com.trm.GestOne.item.ItemStatus;
import com.trm.GestOne.item.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    private Long ItemResponseId;
    private String name;
    private String description;
    private Double purchasePrice;
    private Double salePrice;
    private Double profit;
    private String accessories;
    private Boolean isNew;
    private ItemType itemType;
    private ItemStatus isAvailable;

    private String dayInsertion;
}
