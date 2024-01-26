package dev.vasylenko.learnenglish.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "Synonyms")
public class Synonyms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "synonyms", fetch = FetchType.LAZY)
    private Set<Word> words;

    public Synonyms() {
        words = new HashSet<>();
    }

    public Synonyms(Set<Word> words) {
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> synonyms) {
        this.words = synonyms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Synonyms that)) return false;
        return getId() == that.getId() && Objects.equals(getWords(), that.getWords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWords());
    }
}
