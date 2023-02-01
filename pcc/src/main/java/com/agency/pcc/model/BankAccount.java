package com.agency.pcc.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int id;
    @Column
    private String pan;
    @Column
    private String bankName;
    @Column
    private String bankUrl;
}
