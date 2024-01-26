package dev.vasylenko.learnenglish.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "Word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "You should add some word here!")
    @Column(name = "spelling")
    private String spelling;
    @Column(name = "transcription")
    private String transcription;
    @NotBlank(message = "You should add translation here!")
    @Column(name = "translation")
    private String translation;
    @Column(name = "is_synonym")
    private boolean isSynonym;
    @ManyToOne
    @JoinColumn(name = "synonyms_id", referencedColumnName = "id")
    private Synonyms synonyms;
    @ManyToOne
    @JoinColumn(name = "dictionary_id", referencedColumnName = "id")
    private Dictionary dictionary;

    public Word() {
    }

    public Word(String spelling, String transcription, String translation, boolean isSynonym, Synonyms synonyms, Dictionary dictionary) {
        this.spelling = spelling;
        this.transcription = transcription;
        this.translation = translation;
        this.isSynonym = isSynonym;
        this.synonyms = synonyms;
        this.dictionary = dictionary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public boolean isSynonym() {
        return isSynonym;
    }

    public void setSynonym(boolean synonym) {
        isSynonym = synonym;
    }

    public Synonyms getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(Synonyms synonyms) {
        this.synonyms = synonyms;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word word)) return false;
        return getId() == word.getId() && isSynonym() == word.isSynonym() && Objects.equals(getSpelling(), word.getSpelling()) && Objects.equals(getTranscription(), word.getTranscription()) && Objects.equals(getTranslation(), word.getTranslation()) && Objects.equals(getSynonyms(), word.getSynonyms()) && Objects.equals(getDictionary(), word.getDictionary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSpelling(), getTranscription(), getTranslation(), isSynonym(), getSynonyms(), getDictionary());
    }
}
