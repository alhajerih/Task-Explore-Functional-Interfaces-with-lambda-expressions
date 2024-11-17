package Java_Stream.Java_Stream.service;

import Java_Stream.Java_Stream.bo.CreateSuggestionRequest;
import Java_Stream.Java_Stream.entity.GuestSuggestionEntity;
import Java_Stream.Java_Stream.repository.GuestSuggestionRepository;
import Java_Stream.Java_Stream.util.SuggestionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService {

    @Autowired
    private  GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    SuggestionProcessor processSuggestion = (CreateSuggestionRequest suggestionText)->{
        GuestSuggestionEntity guestSuggestionEntity = new GuestSuggestionEntity();
        guestSuggestionEntity.setSuggestionText(suggestionText.getSuggestionText());
        guestSuggestionEntity.setRate(suggestionText.getRate());
        guestSuggestionEntity.setStatus(SuggestionStatus.valueOf(suggestionText.getStatus()));
        guestSuggestionRepository.save(guestSuggestionEntity);

    };

    // add new suggestion by calling the lambda expression
    public void printAndProcessSuggestion(CreateSuggestionRequest suggestionText){

        processSuggestion.process(suggestionText);
    };

    // get all suggestions
    public List<GuestSuggestionEntity>getAllSuggestions(){
        return guestSuggestionRepository.findAll();
    }

    public List<GuestSuggestionEntity>findAllCreatedSuggestions(){
        return guestSuggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getStatus() == SuggestionStatus.CREATE)
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity>findAllRemovedSuggestions (){
        return guestSuggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getStatus() == SuggestionStatus.REMOVE)
                .collect(Collectors.toList());
    }

    //Based on whole object to be unique
    public List<GuestSuggestionEntity>soUniqueSuggestion(){
        return guestSuggestionRepository.findAll().stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Based on the suggestionText string
    public List<GuestSuggestionEntity>uniqueSuggestion(){
        Set<String> seen = new HashSet<>();
        return guestSuggestionRepository.findAll().stream()
                .filter(suggestion -> seen.add(suggestion.getSuggestionText()))
                .collect(Collectors.toList());
    }


}
