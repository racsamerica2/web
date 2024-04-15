package pe.edu.upc.demosv64.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "GreenArea")
public class GreenArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGreenArea;
    @Column(name = "nameGreenArea",nullable = false,length = 45)
    private String nameGreenArea;
    @Column(name = "extensionGreenArea",nullable = false)
    private float extensionGreenArea;
    @Column(name = "dateCreationGreenArea",nullable = false)
    private LocalDate dateCreationGreenArea;
    @Column(name = "ubicationGreenArea",nullable = false,length = 45)
    private String ubicationGreenArea;

    public GreenArea() {
    }

    public GreenArea(int idGreenArea, String nameGreenArea, float extensionGreenArea, LocalDate dateCreationGreenArea, String ubicationGreenArea) {
        this.idGreenArea = idGreenArea;
        this.nameGreenArea = nameGreenArea;
        this.extensionGreenArea = extensionGreenArea;
        this.dateCreationGreenArea = dateCreationGreenArea;
        this.ubicationGreenArea = ubicationGreenArea;
    }

    public int getIdGreenArea() {
        return idGreenArea;
    }

    public void setIdGreenArea(int idGreenArea) {
        this.idGreenArea = idGreenArea;
    }

    public String getNameGreenArea() {
        return nameGreenArea;
    }

    public void setNameGreenArea(String nameGreenArea) {
        this.nameGreenArea = nameGreenArea;
    }

    public float getExtensionGreenArea() {
        return extensionGreenArea;
    }

    public void setExtensionGreenArea(float extensionGreenArea) {
        this.extensionGreenArea = extensionGreenArea;
    }

    public LocalDate getDateCreationGreenArea() {
        return dateCreationGreenArea;
    }

    public void setDateCreationGreenArea(LocalDate dateCreationGreenArea) {
        this.dateCreationGreenArea = dateCreationGreenArea;
    }

    public String getUbicationGreenArea() {
        return ubicationGreenArea;
    }

    public void setUbicationGreenArea(String ubicationGreenArea) {
        this.ubicationGreenArea = ubicationGreenArea;
    }
}
