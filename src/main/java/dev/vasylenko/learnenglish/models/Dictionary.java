package dev.vasylenko.learnenglish.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "dictionary", fetch = FetchType.LAZY)
    private List<Word> words;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "language")
    private Language language;

    public Dictionary() {
    }

    public Dictionary(List<Word> words, User user, Language language) {
        this.words = words;
        this.user = user;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dictionary that)) return false;
        return getId() == that.getId() && Objects.equals(getWords(), that.getWords()) && Objects.equals(getUser(), that.getUser()) && getLanguage() == that.getLanguage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWords(), getUser(), getLanguage());
    }
}
