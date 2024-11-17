package Java_Stream.Java_Stream.service;

import Java_Stream.Java_Stream.bo.CreateSuggestionRequest;

@FunctionalInterface
public interface SuggestionProcessor {
    void process(CreateSuggestionRequest suggestionText);
}
