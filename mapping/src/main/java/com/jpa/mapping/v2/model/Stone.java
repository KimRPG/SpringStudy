package com.jpa.mapping.v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stone_id")
    private int id;

    private String stoneName;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "pocket_id")
    @JsonManagedReference
    private Pocket pocket;

    @Builder
    public Stone(String stoneName, Pocket pocket) {
        this.stoneName = stoneName;
        this.pocket = pocket;
    }

    public static Stone createStone(String stoneName, Pocket pocket) {
        return Stone.builder()
                .stoneName(stoneName)
                .pocket(pocket)
                .build();
    }
}