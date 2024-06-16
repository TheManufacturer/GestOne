package com.trm.GestOne.item;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trm.GestOne.item.ItemDto.ItemRequest;
import com.trm.GestOne.item.ItemDto.ItemResponse;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    //attention here!!! with dayPurchase and daySale
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private OffsetDateTime dayPurchase;


    @PrePersist
    public void prePersist(){
        this.dayPurchase = OffsetDateTime.now();
    }

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
                itemInfo.getDayPurchase()
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
                itemModel.getDayPurchase() == null ? "" : itemModel.getDayPurchase().toString()
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
                itemRequest.getDayPurchase() == null ? OffsetDateTime.now() : OffsetDateTime.parse(itemRequest.getDayPurchase())

//              OffsetDateTime.parse(itemRequest.getDayPurchase())
        );
    }

}
