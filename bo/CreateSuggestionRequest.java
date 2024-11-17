package Java_Stream.Java_Stream.bo;


public class CreateSuggestionRequest {

    private int rate;
    private String suggestionText;
    private String status;
    public CreateSuggestionRequest(int rate, String suggestionText, String status) {
        this.rate = rate;
        this.suggestionText = suggestionText;
        this.status = status;
    }



    // Getter and Setter


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
