package fereusz.InformationFlow.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @EqualsAndHashCode(of ="id") @ToString(exclude = {"fund","user","feedbacks"})

@Entity
@Table(name = "fund_managers")
public class FundManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false)
    private String sector;
    @Column(nullable = false)
    private String fullName = firstName+" "+secondName;

    @ManyToOne
    private Fund fund;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "fundManager")
    private List<Feedback> feedbacks = new ArrayList<>();

    public String getFullName() {
        return firstName + " " + secondName;
    }







}
