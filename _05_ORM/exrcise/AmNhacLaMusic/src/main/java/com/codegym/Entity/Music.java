package com.codegym.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusic;
    @Column(name = "ten_bai_hat", columnDefinition = "varchar(50)")
    private String nameMusic;
    @Column(name = "ten_ca_si", columnDefinition = "varchar(50)")

    private String nameSinger;
    @Column(name = "Loai_bai_hat", columnDefinition = "varchar(50)")

    private String typeMusic;
    @Column(name = "Link_bai_hat", columnDefinition = "varchar(50)")

    private String link;

    @Column(name = "nghe_nhac", columnDefinition = "varchar(50)")
    @Value("${file}")
    private String play;

    public Music() {

    }

    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }
}
