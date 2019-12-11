package fereusz.InformationFlow.dtos;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class FeedbackDTO {

    @NotBlank
    @Size(max = 2000)
    private String content;
    private Long fundManagerId;
    private Long fundId;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime localDateTime = LocalDateTime.now();

}



