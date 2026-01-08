package com.hazem.demo.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    //One User → Many Address records
    // mappedBy = "user" define the owner of the relationship
    //Cascade = “do the same action on the child when I do it on the parent”
    //cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    // orphanRemoval = true : Deletes child when removed from the list
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private List<Address> addresses =new ArrayList<>();

    public void addAddress(Address address){
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address){
    addresses.remove(address);
    address.setUser(null);
    }



// There is NO column in the user table called favoriteProducts
// The relationship is stored ONLY in the wishlist table.
    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private Set<Product> favoriteProducts  = new HashSet<>();

    public void addFavoriteProduct(Product product){
        favoriteProducts .add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
