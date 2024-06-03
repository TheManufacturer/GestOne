package com.trm.GestOne.item;
import com.trm.GestOne.item.ItemDto.ItemRequest;
import com.trm.GestOne.item.ItemDto.ItemResponse;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {

    private Long id;
    private String name;
    private String description;
    private Double purchasePrice;
    private Double salePrice;
    private Double profit;
    private String accessories;
    private Boolean isNew;
    private ItemType itemType;
    private ItemStatus isAvailable;
    private OffsetDateTime dayPurchase;
    private OffsetDateTime daySale;

    //Entity to Model
    public static ItemModel mapEntityToModel(Item itemInfo) {
        return new ItemModel(
                itemInfo.getItemId(),
                itemInfo.getName(),
                itemInfo.getDescription(),
                itemInfo.getPurchasePrice(),
                itemInfo.getSalePrice(),
                itemInfo.getProfit(),
                itemInfo.getAccessories(),
                itemInfo.getIsNew(),
                itemInfo.getItemType(),
                itemInfo.getIsAvailable(),
                itemInfo.getDayPurchase(),
                itemInfo.getDaySale()
        );
    }

    //Model to Entity
    public static Item mapModelToEntity(ItemModel itemModel) {
        return new Item(
                itemModel.getId(),
                itemModel.getName(),
                itemModel.getDescription(),
                itemModel.getPurchasePrice(),
                itemModel.getSalePrice(),
                itemModel.getProfit(),
                itemModel.getAccessories(),
                itemModel.getIsNew(),
                itemModel.getItemType(),
                itemModel.getIsAvailable(),
                itemModel.getDayPurchase(),
                itemModel.getDaySale(),
                new HashSet<>()
        );
    }

    //Model to Response
    public static ItemResponse mapModelToResponse(ItemModel itemModel) {
        return new ItemResponse(
                itemModel.getId(),
                itemModel.getName(),
                itemModel.getDescription(),
                itemModel.getPurchasePrice(),
                itemModel.getSalePrice(),
                itemModel.getProfit(),
                itemModel.getAccessories(),
                itemModel.getIsNew(),
                itemModel.getItemType(),
                itemModel.getIsAvailable(),
                itemModel.getDayPurchase().toString(),
                itemModel.getDaySale().toString()
        );
    }

    //Model to Request
    public static ItemModel mapRequestToModel(ItemRequest itemRequest) {
        return new ItemModel(
                null,
                itemRequest.getName(),
                itemRequest.getDescription(),
                itemRequest.getPurchasePrice(),
                itemRequest.getSalePrice(),
                itemRequest.getProfit(),
                itemRequest.getAccessories(),
                itemRequest.getIsNew(),
                itemRequest.getItemType(),
                itemRequest.getIsAvailable(),
                OffsetDateTime.parse(itemRequest.getDayPurchase()),
                OffsetDateTime.parse(itemRequest.getDaySale())
        );
    }

}
