package dev.vasylenko.learnenglish.models;

public enum Language {
    ENGLISH("ENG"), GERMAN("GER"), ITALIAN("IT"), FRENCH("FR"), RUSSIAN("RU"), UKRAINIAN("UKR");
    private String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
