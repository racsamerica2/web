package pe.edu.upc.demosv64.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class GreenAreaDTO {
    private int idGreenArea;
    private String nameGreenArea;
    private float extensionGreenArea;
    private LocalDate dateCreationGreenArea;
    private String ubicationGreenArea;

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
