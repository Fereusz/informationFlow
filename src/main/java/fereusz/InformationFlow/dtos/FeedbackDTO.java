package fereusz.InformationFlow.dtos;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class FeedbackDTO {

    @NotBlank
    @Size(max = 2000)
    private String content;
    @NotNull
    private Long fundManagerId;
    @NotNull
    private Long fundId;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime localDateTime = LocalDateTime.now();

}



