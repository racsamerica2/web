package pe.edu.upc.demosv64.servicesinterfaces;

import pe.edu.upc.demosv64.entities.GreenArea;

import java.time.LocalDate;
import java.util.List;

public interface IGreenAreaServiceInterface {
    public void insert(GreenArea greenArea);

    public List<GreenArea> list();

    public void delete(int idGreenArea);

    public GreenArea listarId(int idGreenArea);

    public List<GreenArea> findByDateCreationGreenArea(LocalDate fecha);
}
