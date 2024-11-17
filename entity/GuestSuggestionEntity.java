package Java_Stream.Java_Stream.entity;

import Java_Stream.Java_Stream.util.SuggestionStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Suggestions")
public class GuestSuggestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String suggestionText;
    @Enumerated(EnumType.STRING)
    private SuggestionStatus status;

    // Getter and Setter

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GuestSuggestionEntity that = (GuestSuggestionEntity) o;
        return rate == that.rate && Objects.equals(suggestionText, that.suggestionText) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, suggestionText, status);
    }
}
