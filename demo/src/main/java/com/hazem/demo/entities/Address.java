package com.hazem.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="zip")
    private String zip;

    @Column(name="state")
    private String state;
//LAZY = the user object is not loaded immediately from the database.
//It is fetched only when you actually access it,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;




}
