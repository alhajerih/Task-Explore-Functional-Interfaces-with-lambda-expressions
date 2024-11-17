package Java_Stream.Java_Stream.bo;


public class CreateSuggestionRequest {

    private int rate;
    private String suggestionText;

    public CreateSuggestionRequest(int rate, String suggestionText) {
        this.rate = rate;
        this.suggestionText = suggestionText;
    }



    // Getter and Setter


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }
}
