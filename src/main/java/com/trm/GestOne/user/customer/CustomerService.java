package com.trm.GestOne.user.customer;

import com.trm.GestOne.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    UserRepository userRepository;

    // 1. Esplorazione del catalogo dei prodotti
//    - Visualizzare i prodotti disponibili nel catalogo
//    - Cercare prodotti per categoria, nome, prezzo, ecc.

// 2. Gestione dell'account
//    - Registrarsi come nuovo cliente
//    - Effettuare il login
//    - Aggiornare le informazioni personali (come indirizzo di spedizione, metodo di pagamento preferito, ecc.)
//    - Gestire le impostazioni dell'account

// 3. Gestione degli ordini
//    - Piazzare nuovi ordini
//    - Visualizzare lo storico degli ordini passati
//    - Monitorare lo stato degli ordini in corso (ad esempio, in elaborazione, spedito, consegnato)
//    - Gestire resi o problemi relativi agli ordini

// 4. Gestione del carrello
//    - Aggiungere o rimuovere prodotti dal carrello
//    - Modificare la quantità dei prodotti nel carrello
//    - Procedere al checkout per completare l'ordine

// 5. Gestione dei pagamenti
//    - Selezionare il metodo di pagamento preferito
//    - Visualizzare lo storico dei pagamenti e delle transazioni relative ai propri ordini

// 6. Visualizzazione del profilo
//    - Visualizzare e aggiornare le proprie informazioni personali (nome, indirizzo, email, ecc.)

// 7. Gestione delle recensioni
//    - Lasciare recensioni e valutazioni sui prodotti acquistati

// 8. Supporto clienti
//    - Contattare il supporto clienti per domande, problemi o chiarimenti relativi ai prodotti, agli ordini o all'account

}
