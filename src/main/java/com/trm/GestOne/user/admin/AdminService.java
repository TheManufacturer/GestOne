package com.trm.GestOne.user.admin;

import com.trm.GestOne.item.Item;
import com.trm.GestOne.item.ItemDto.ItemRequest;
import com.trm.GestOne.item.ItemDto.ItemResponse;
import com.trm.GestOne.item.ItemModel;
import com.trm.GestOne.item.ItemRepository;
import com.trm.GestOne.user.UserRepository;
import com.trm.GestOne.warehouse.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    //  Gestione Item

    // Retrieves all items from the database and converts them to ItemResponse objects for HTTP response
    public List<ItemResponse> getAllItem(){
        // Retrieve all items from the database
        List<Item> response = itemRepository.findAll();

        // Create a list to hold ItemResponse objects
        List<ItemResponse> result = new ArrayList<>();

        // Iterate through each item and convert to ItemResponse
        for (Item item : response) {

            //convert to model
            ItemModel itemModel = ItemModel.mapEntityToModel(item);

            //convert model to Response
            result.add(ItemModel.mapModelToResponse(itemModel));
        }
        //return list of --> ItemResponse
        return result;
    }

    //Todo Here --> maybe we can automatize the dayPurchase with the addItem
    //This method add an Item and add to DB --> from Request to Entity :)
    public ItemResponse addItem(ItemRequest newItemRequest){
        //Convert request to model
        ItemModel itemRequestModel = ItemModel.mapRequestToModel(newItemRequest);
        //Convert model to entity
        Item itemRequestEntity = ItemModel.mapModelToEntity(itemRequestModel);
        //Save entity in Db by saveAndFlush
        Item savedItem = itemRepository.saveAndFlush(itemRequestEntity);
        //convert the savedItem (Entity) to response
        ItemModel itemResponseModel = ItemModel.mapEntityToModel(savedItem);
        //return It by response
        return ItemModel.mapModelToResponse(itemResponseModel);
    }

    //This method found and delete an Item from DB
    public boolean deleteItem (Long itemId){
        //Exist this ItemId? :)
        if(itemRepository.existsById(itemId)){
            //delete it
            itemRepository.deleteById(itemId);
            return true;
        }
        //not  exist...false
        return false;
    }



}
