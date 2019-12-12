package fereusz.InformationFlow.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Getter @Setter @ToString(exclude = {"user", "fundManager"}) @EqualsAndHashCode(of = "id")

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 2000)
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime localDateTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private FundManager fundManager;


}
