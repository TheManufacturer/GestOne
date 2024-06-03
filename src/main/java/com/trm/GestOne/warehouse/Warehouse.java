package com.trm.GestOne.warehouse;

import com.trm.GestOne.item.Item;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String manager;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "item_warehouse",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items = new HashSet<>();

    /*
    Quest'entità verrà utilizzata in modo tale che un item avrà una destinazione in un magazzino specifico.
    Inoltre avremo la possibilità di avere dei report sui magazzini in questione.
    */
}
