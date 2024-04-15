package pe.edu.upc.demosv64.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demosv64.entities.Maintenance;

import java.util.List;

@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    @Query(value = "select a.name_green_area as AreaVerde ,count(*) as Mantenimientos \n" +
            "                       from green_area a inner join Maintenance m \n" +
            "                       on a.id_green_area=m.id_green_area \n" +
            "                       group by  a.name_green_area",nativeQuery = true)
    public List<String[]>quantityMaintenanceByGreenArea();

    @Query(value = "select r.name_green_area as AreaVerde ,sum(m.amount_maintenance) as Mantenimientos\n" +
            " from green_area r inner join maintenance m\n" +
            " on r.id_green_area=m.id_green_area\n" +
            " group by  r.name_green_area",nativeQuery = true)
    public List<String[]>moneyByMaintenanceByGreenArea();

    @Query("from Maintenance m where m.greenArea.nameGreenArea=:area ")
    public List<Maintenance> maintenanceByGreenArea(@Param("area") String verde);



}
