package com.trm.GestOne.item;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

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
        private Long id;

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

        @Column(nullable = false)
        private OffsetDateTime daySale;
}

