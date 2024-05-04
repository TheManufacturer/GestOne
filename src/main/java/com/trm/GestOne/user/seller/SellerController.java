package com.trm.GestOne.user.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {
    @Autowired
    SellerService sellerService;

    //Qui Il Controller del nostro venditore
    //Controllare i metodi su service, poi verrano richiamati qui
}
