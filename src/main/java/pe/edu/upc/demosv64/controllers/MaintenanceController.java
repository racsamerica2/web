package pe.edu.upc.demosv64.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demosv64.dtos.MaintenanceByGreenAreaDTO;
import pe.edu.upc.demosv64.dtos.MaintenanceDTO;
import pe.edu.upc.demosv64.dtos.MoneyMaintenanceByGreenAreaDTO;
import pe.edu.upc.demosv64.entities.Maintenance;
import pe.edu.upc.demosv64.servicesinterfaces.IMaintenanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mantenimientos")
public class MaintenanceController {
    @Autowired
    private IMaintenanceService mS;

    @PostMapping
    public void insertar(@RequestBody MaintenanceDTO maintenanceDTO) {
        ModelMapper m = new ModelMapper();
        Maintenance mT = m.map(maintenanceDTO, Maintenance.class);
        mS.insert(mT);


    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<MaintenanceDTO> listar() {
        return mS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidamantenimeintos")
    public List<MaintenanceByGreenAreaDTO> dineroZapato() {
        List<String[]> filaLista = mS.quantityMaintenanceByGreenArea();
        List<MaintenanceByGreenAreaDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            MaintenanceByGreenAreaDTO dto = new MaintenanceByGreenAreaDTO();
            dto.setNameGreenArea(columna[0]);
            dto.setQuantityMaintenance(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/dineromantenimientos")
    public List<MoneyMaintenanceByGreenAreaDTO> dineroMaintenance() {
        List<String[]> filaLista = mS.moneyByMaintenanceByGreenArea();
        List<MoneyMaintenanceByGreenAreaDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            MoneyMaintenanceByGreenAreaDTO dto = new MoneyMaintenanceByGreenAreaDTO();
            dto.setNameGreenArea(columna[0]);
            dto.setMoneyMaintenance(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/buscarareaverde")
    public List<MaintenanceDTO> findAreaVerde(@RequestParam String area){
        return mS.maintenanceByGreenArea(area).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,MaintenanceDTO.class);
        }).collect(Collectors.toList());
    }

}
