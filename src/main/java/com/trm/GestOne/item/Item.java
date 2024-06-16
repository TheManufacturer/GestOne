package com.trm.GestOne.item;

import com.trm.GestOne.warehouse.Warehouse;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id")
        private Long itemId;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String description;

        @Column(nullable = false)
        private Double purchasePrice;

        @Column(nullable = false)
        private Double salePrice;

        @Column(nullable = false)
        private Double profit;

        @Column(nullable = false)
        private String accessories;     // Eventuali accessori a corredo

        @Column(nullable = false)
        private Boolean isNew;          //Item: nuovo o usato

        @Enumerated(EnumType.STRING)    //Item: Tipo
        private ItemType itemType;

        @Enumerated(EnumType.STRING)
        private ItemStatus isAvailable; //Item: ordinabile, acquistabile, non disponibile

        @Column(nullable = false)
        private OffsetDateTime dayPurchase;

        @ManyToMany(mappedBy = "items")
        private Set<Warehouse> warehouses = new HashSet<>();

}

