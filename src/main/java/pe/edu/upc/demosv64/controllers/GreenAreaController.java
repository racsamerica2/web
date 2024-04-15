package pe.edu.upc.demosv64.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demosv64.dtos.GreenAreaDTO;
import pe.edu.upc.demosv64.entities.GreenArea;
import pe.edu.upc.demosv64.servicesinterfaces.IGreenAreaServiceInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("areasverdes")
public class GreenAreaController {
    @Autowired
    private IGreenAreaServiceInterface gS;

    @PostMapping
    public void registrar(@RequestBody GreenAreaDTO dto) {
        ModelMapper c = new ModelMapper();
        GreenArea a = c.map(dto, GreenArea.class);
        gS.insert(a);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<GreenAreaDTO> list() {
        return gS.list().stream().map(y -> {
            ModelMapper c = new ModelMapper();
            return c.map(y, GreenAreaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        gS.delete(id);
    }

    @GetMapping("/{id}")
    public GreenAreaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        GreenAreaDTO g = m.map(gS.listarId(id), GreenAreaDTO.class);
        return g;
    }

    @GetMapping("/buscar")
    public List<GreenAreaDTO> buscar(@RequestParam LocalDate fecha) {
        return gS.findByDateCreationGreenArea(fecha).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, GreenAreaDTO.class);
        }).collect(Collectors.toList());
    }
}

