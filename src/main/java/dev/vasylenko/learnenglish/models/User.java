package dev.vasylenko.learnenglish.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Apps_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Please specify your name")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Please specify your email")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "Please specify your password")
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Dictionary> dictionaries;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        dictionaries = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Dictionary> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(Set<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getDictionaries(), user.getDictionaries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getDictionaries());
    }
}
