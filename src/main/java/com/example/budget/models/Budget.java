package com.example.budget.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "funds")
    private Integer funds;

    @Column(name = "date")
    private Date date;

}