package fereusz.InformationFlow.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @EqualsAndHashCode(of ="id") @ToString(exclude = {"managers","user"})

@Entity
@Table(name = "funds")
public class Fund {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "aum", nullable = false)
    private Double assetsUnderManagement;
    @Column(nullable = false)
    private Integer tier;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "fund")
    private List<FundManager> managers = new ArrayList<>();


}
