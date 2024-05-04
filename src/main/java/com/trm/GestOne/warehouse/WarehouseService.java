package com.trm.GestOne.warehouse;

import com.trm.GestOne.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    @Autowired
    ItemRepository itemRepository;

//1. Aggiunta di un nuovo magazzino: Permette di creare un nuovo magazzino nel sistema.

//2. Modifica di un magazzino esistente: Permette di aggiornare le informazioni di un magazzino esistente, ad esempio il nome, la capacità, lo stato, il responsabile, ecc.

//3. Rimozione di un magazzino: Permette di eliminare un magazzino dal sistema.

//4. Recupero di tutti i magazzini: Restituisce un elenco di tutti i magazzini presenti nel sistema.

//5. Recupero di un magazzino per ID: Restituisce un magazzino specifico in base al suo ID.

//6. Aggiunta di un articolo a un magazzino: Permette di associare un articolo a un magazzino esistente.

//7. Rimozione di un articolo da un magazzino: Permette di dissociare un articolo da un magazzino esistente.

//8. Recupero di tutti gli articoli di un magazzino: Restituisce un elenco di tutti gli articoli associati a un magazzino specifico.
}
