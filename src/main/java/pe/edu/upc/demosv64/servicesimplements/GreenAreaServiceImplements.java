package pe.edu.upc.demosv64.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demosv64.entities.GreenArea;
import pe.edu.upc.demosv64.repositories.IGreenAreaRepository;
import pe.edu.upc.demosv64.servicesinterfaces.IGreenAreaServiceInterface;

import java.time.LocalDate;
import java.util.List;

@Service
public class GreenAreaServiceImplements implements IGreenAreaServiceInterface {
    @Autowired
    private IGreenAreaRepository gR;

    @Override
    public void insert(GreenArea greenArea) {
        gR.save(greenArea);
    }

    @Override
    public List<GreenArea> list() {
        return gR.findAll();
    }

    @Override
    public void delete(int idGreenArea) {
        gR.deleteById(idGreenArea);
    }

    @Override
    public GreenArea listarId(int idGreenArea) {
        return gR.findById(idGreenArea).orElse(new GreenArea());
    }

    @Override
    public List<GreenArea> findByDateCreationGreenArea(LocalDate fecha) {
        return gR.findByDateCreationGreenArea(fecha);
    }
}
