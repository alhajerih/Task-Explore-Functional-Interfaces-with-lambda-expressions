package Java_Stream.Java_Stream.service;

import Java_Stream.Java_Stream.bo.CreateSuggestionRequest;
import Java_Stream.Java_Stream.entity.GuestSuggestionEntity;
import Java_Stream.Java_Stream.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
