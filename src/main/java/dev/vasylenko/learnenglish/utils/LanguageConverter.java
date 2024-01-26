package dev.vasylenko.learnenglish.utils;

import dev.vasylenko.learnenglish.models.Language;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class LanguageConverter implements AttributeConverter<Language, String> {
 
    @Override
    public String convertToDatabaseColumn(Language language) {
        if (language == null) {
            return null;
        }
        return language.getCode();
    }

    @Override
    public Language convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Language.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}