package fereusz.InformationFlow.domain.entities;


import ch.qos.logback.core.net.server.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")

@Getter @Setter @ToString(exclude = {"password","roles","fundList","fundManagers"}) @EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Boolean active = Boolean.FALSE;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    @OneToMany
    private List<Fund> fundList=new ArrayList<>();

    @OneToMany
    private List<FundManagers> fundManagers = new ArrayList<>();




}
