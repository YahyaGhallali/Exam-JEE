# Rapport Exam JEE

## Conception

### Architecture du projet

### Digramme de class

```mermaid
classDiagram
    class Client {
        +Long id
        +String nom
        +String email
    }

    class Credit {
        +Long id
        +Date dateDemande
        +Status statut
        +Date dateAcceptation
        +Double montant
        +Integer dureeRemboursement
        +Double tauxInteret
    }

    Credit --> Status

    class Status {
        <<ENUM>>
        EnCours
        Accepted
        Rejected
    }

    class CreditPersonnel {
        +String motif
    }

    class CreditImmobilier {
        +Bien typeBien
    }

    CreditImmobilier --> Bien

    class Bien {
        <<ENUM>>
        Appartement
        Maison
        LocalCommercial
    }



    class CreditProfessionnel {
        +String motif
        +String raisonSociale
    }

    class Remboursement {
        +Long id
        +Date date
        +Double montant
        +Type type
    }

        Remboursement --> Type

    class Type {
        <<ENUM>>
        Mensualité
        Remboursement
        Anticipé
    }



    Client "1" -- "*" Credit : effectuer un crédit

    Credit "1" -- "*" Remboursement
    Credit <|-- CreditPersonnel
    Credit <|-- CreditImmobilier
    Credit <|-- CreditProfessionnel
```


## Couche DAO
### Entités JPA

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "client")
    @Builder.Default
    private List<Credit> credits = new ArrayList<>();
}
```

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateDemande;
    @Enumerated(EnumType.STRING)
    private Status statut;
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements = new ArrayList<>();
}
```

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private Double montant;
    private Type type;

    @ManyToOne
    private Credit credit;
}
```

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("CreditImmobilier")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private Bien typeBien;
}
```

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("CreditProfessionnel")
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
```

```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("CreditPersonnel")
public class CreditPersonnel extends Credit {
    private String motif;
}
```
### Interface JPA

```java
public interface ClientRepository extends JpaRepository<Client, Long> {

}
```

```java
public interface CreditRepository extends JpaRepository<Credit, Long> {
}
```

```java
public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
}
```

```java
public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
}
```

```java
public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
}
```

```java
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}
```

## Couche Service
### DTO

```java
@Data
public abstract class CreditDTO {
    private Long id;
    private Date dateDemande;
    private Status statut;
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;

    private List<RemboursementDTO> remboursements;
}
```

```java
@Data
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;

    private List<CreditDTO> credits;
}
```

```java
@Data
@Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private Type type;
}
```

```java
@Data
@Builder
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}
```

```java
@Data
@Builder
public class CreditImmobilierDTO extends CreditDTO {
    private Bien typeBien;
}
```

```java
@Data
@Builder
public class CreditProfessionelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}
```
### REST Controllers
