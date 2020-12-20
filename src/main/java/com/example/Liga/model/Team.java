package com.example.Liga.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private LocalDate creationDate;
    private String shield;



    @ElementCollection
    @Column(name = "cups")
    private List<String> cups = new ArrayList<>();



    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<Player> players = new HashSet<Player>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="match_id")
    private Match match;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="liga_id")
    private Liga liga;


    //region Constructores
    public Team() {
    }

    public Team(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
    //endregion

    //region Methods
    public void addPlayer(Player newPlayer){
        this.players.add(newPlayer);
        newPlayer.setTeam(this);
    }


    public void assignTeam(Team team, Player player){
        team.players.add(player);
    }

    public int getPlayersAmount(){
        return this.players.size();
    }

    public void addCup(String newCup){
        cups.add(newCup);
    }

    //endregion

    //region Getters & Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getShield() {
        return shield;
    }

    public List<String> getCups() {
        return cups;
    }

    public void setCups(List<String> cups) {
        this.cups = cups;
    }


    public Set<Player> getPlayers() {
        return players;


    }

    public void setMatch(Match match) {
        this.match = match;
    }
//endregion

}
