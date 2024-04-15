package pe.edu.upc.demosv64.servicesinterfaces;

import pe.edu.upc.demosv64.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);
}
