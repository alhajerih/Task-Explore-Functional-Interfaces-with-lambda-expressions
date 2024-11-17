package Java_Stream.Java_Stream.controller;

import Java_Stream.Java_Stream.bo.CreateSuggestionRequest;
import Java_Stream.Java_Stream.entity.GuestSuggestionEntity;
import Java_Stream.Java_Stream.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class GuestSuggestionController {


    @Autowired
    private final GuestSuggestionService guestSuggestionService;

    public GuestSuggestionController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }


    @PostMapping("/suggest")
    public ResponseEntity<String> suggest(@RequestBody CreateSuggestionRequest  request){
        guestSuggestionService.printAndProcessSuggestion(request);
        return ResponseEntity.ok("Suggest added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<GuestSuggestionEntity>>allSuggestions(){

       List<GuestSuggestionEntity>allSuggestions = guestSuggestionService.getAllSuggestions();

        return ResponseEntity.ok(allSuggestions);
    }

}
