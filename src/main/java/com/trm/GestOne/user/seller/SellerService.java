package com.trm.GestOne.user.seller;

import com.trm.GestOne.item.ItemRepository;
import com.trm.GestOne.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    //Qui Il Service del nostro venditore

// 1. Gestione Prodotti
//    - Aggiungere nuovi prodotti al catalogo
//    - Modificare dati dei prodotti
//    - Eliminare prodotti

// 2. Gestione Ordini
//    - Visualizzare la lista degli ordini relativi ai propri prodotti
//    - Aggiornare lo stato degli ordini per i propri prodotti

// 3. Gestione Inventario
//    - Monitorare il livello di stock dei propri prodotti
//    - Gestire il riassortimento e la disponibilità dei prodotti

// 4. Gestione Profilo
//    - Modificare le informazioni personali del venditore
//    - Aggiornare le informazioni di contatto

// 5. Gestione Pagamenti
//    - Visualizzare lo storico dei pagamenti e delle transazioni relativi ai propri prodotti

// 6. Gestione Feedback
//    - Visualizzare e rispondere ai feedback e alle recensioni dei clienti sui propri prodotti

// 7. Gestione Promozioni
//    - Creare e gestire promozioni e sconti sui propri prodotti

// 8. Supporto Clienti
//    - Fornire assistenza e supporto ai clienti per domande e problemi relativi ai propri prodotti

}