package com.example.les13relationstechiteasy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    // Dit is de target kant van de relatie. Er staat niks in de database
    //Deze annotatie definieert de één-op-veel-relatie tussen WallBracket en TelevisionWallBracket. De mappedBy-eigenschap geeft aan dat de relatie wordt beheerd door het veld wallBracket in de TelevisionWallBracket-klasse.
    @OneToMany(mappedBy = "wallBracket")
    //Deze annotatie geeft aan dat het veld televisionWallBrackets moet worden genegeerd bij het serialiseren van het WallBracket-object naar JSON-formaat. Dit helpt om oneindige recursie te voorkomen tijdens het serialiseren van gerelateerde objecten.
    @JsonIgnore
    List<TelevisionWallBracket> televisionWallBrackets;

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<TelevisionWallBracket> getTelevisionWallBrackets() {
        return televisionWallBrackets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTelevisionWallBrackets(List<TelevisionWallBracket> televisionWallBrackets) {
        this.televisionWallBrackets = televisionWallBrackets;
    }

}
