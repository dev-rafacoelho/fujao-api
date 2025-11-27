package com.fujao.animais_encontrados;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob; // Importe o @Lob
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "animal_encontrado")
public class AnimalEncontrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "cor")
    private String cor;

    @Column(name = "raca")
    private String raca;

    @Column(name = "especie")
    private String especie;

    @Column(name = "descricao")
    private String descricao;
    
    // NOVO CAMPO: Imagem em formato Base64
    @Lob // Usado para armazenar strings de texto longo
    @Column(name = "imagem_base64")
    private String imagem_base64; 

    // ------------------------------------
    // GETTERS E SETTERS
    // ------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getImagem_base64() {
        return imagem_base64;
    }

    public void setImagem_base64(String imagem_base64) {
        this.imagem_base64 = imagem_base64;
    }
}