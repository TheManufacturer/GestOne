package com.trm.GestOne.warehouse;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wareHouseId;

    private String name;
    private Integer capacity;
    private String status;
    private String manager;

    /*
    Quest'entità verrà utilizzata in modo tale che un item avrà una destinazione in un magazzino specifico.
    Inoltre avremo la possibilità di avere dei report sui magazzini in questione.
    */
}
