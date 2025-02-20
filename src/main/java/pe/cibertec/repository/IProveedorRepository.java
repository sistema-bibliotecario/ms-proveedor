package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.model.Proveedor;


public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
