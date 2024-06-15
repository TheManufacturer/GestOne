package com.trm.GestOne.user.admin;

import com.trm.GestOne.item.ItemDto.ItemRequest;
import com.trm.GestOne.item.ItemDto.ItemResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin Options", description = "All Functions needed for our admins")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    //All Item
    @GetMapping("/admin/getAllItem")
    public ResponseEntity<?> getItem(){
        List<ItemResponse> itemResponseList = adminService.getAllItem();

        //Manage the response
        if (itemResponseList == null || itemResponseList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item List is null or empty");
        }
        return ResponseEntity.ok(itemResponseList);
    }

    //Create new Item
    @PostMapping("/admin/addItem")
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemRequest newItemRequest){
        return ResponseEntity.ok(adminService.addItem(newItemRequest));
    }

    //Delete Item
    @DeleteMapping("/admin/{itemId}/deleteItemById")
    public ResponseEntity<?> deleteItemById(@PathVariable Long itemId){
        boolean itemFoundAndDeleted = adminService.deleteItem(itemId);
        if(itemFoundAndDeleted) {
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found");
        }
    }

}
