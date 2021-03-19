package com.spring.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String secondName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private Integer numberINN;

    @Column(unique = true)
    private String email;

    private String phone;

    private LocalDate dateBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
    private Subdivision subdivision;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    private LocalDate vacationStart;

    private LocalDate vacationFinal;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String nameFirm;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_store", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "store_id")})
    private List<Store> stores = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistories = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistoriesProvider = new ArrayList<>();

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return getFirstName() + " " + getLastName() + " " + getSecondName();
    }

    public String getUserRole() {
        return role.getNameRole();
    }

    public Boolean isAdmin() {
        return role.name().contains("ADMIN");
    }

    public Boolean isProvider() {
        return role.name().contains("PROVIDER");
    }

    public Boolean isSeller() {
        return role.name().contains("SELLER");
    }

    public Boolean isStorekeeper() {
        return role.name().contains("STOREKEEPER");
    }

    public Boolean isCustomer() {
        return role.name().contains("CUSTOMER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNameFirm() {
        return nameFirm;
    }
}
