package Java_Stream.Java_Stream.controller;

import Java_Stream.Java_Stream.bo.CreateSuggestionRequest;
import Java_Stream.Java_Stream.entity.GuestSuggestionEntity;
import Java_Stream.Java_Stream.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestionStatus")
public class SuggestionStatusController {

    @Autowired
    private final GuestSuggestionService guestSuggestionService;


    public SuggestionStatusController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }


    @GetMapping("created")
    public ResponseEntity<List<GuestSuggestionEntity>> createdStatus(){
        List<GuestSuggestionEntity> allCreated = guestSuggestionService.findAllCreatedSuggestions();

        return ResponseEntity.ok(allCreated);
    }

    @GetMapping("removed")
    public ResponseEntity<List<GuestSuggestionEntity>> removedStatus(){
        List<GuestSuggestionEntity> allRemoved = guestSuggestionService.findAllRemovedSuggestions();

        return ResponseEntity.ok(allRemoved);
    }

    @GetMapping("/unique")
    public ResponseEntity<List<GuestSuggestionEntity>>uniqueSuggestion(){
        List<GuestSuggestionEntity> unique = guestSuggestionService.uniqueSuggestion();
        return ResponseEntity.ok(unique);
    }

    @GetMapping("/soUnique")
    public ResponseEntity<List<GuestSuggestionEntity>>soUniqueSuggestion(){
        List<GuestSuggestionEntity> soUnique = guestSuggestionService.soUniqueSuggestion();
        return ResponseEntity.ok(soUnique);
    }

}
