package com.trm.GestOne.user.role;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    private RoleType name;

    public enum RoleType {

        ROLE_CUSTOMER,
        ROLE_SELLER,
        ROLE_ADMIN

    }

    /*Aggiungendo questa parte, potremmo creare ruoli "diversi in futuro che non siano
        necessariamente questi "predefiniti"".

    //Costruttore che accetta il ruolo predefinito come parametro
        public Role(RoleType name) {
        this.name = name;
        }

    //Costruttore vuoto richiesto da JPA
        public Role() {}
        }
Modalità --> Esempio :

    Role managerRole = new Role(Role.RoleType.ROLE_MANAGER);
    Role employeeRole = new Role(Role.RoleType.ROLE_EMPLOYEE);
    Role customerSupportRole = new Role(Role.RoleType.ROLE_CUSTOMER_SUPPORT);

    */

}