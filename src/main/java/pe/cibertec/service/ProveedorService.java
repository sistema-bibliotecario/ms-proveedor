package pe.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.cibertec.entity.Libro;
import pe.cibertec.feignClient.ILibroFeignClient;
import pe.cibertec.model.Proveedor;
import pe.cibertec.repository.IProveedorRepository;

import java.util.List;

@Service
public class ProveedorService {
	
	@Autowired
    IProveedorRepository proveedorRepository;

    @Autowired
    ILibroFeignClient libroFeignClient;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));
    }

    public void agregarProveedor(Proveedor libro) {
        proveedorRepository.save(libro);
    }

    public String actualizarProveedor(Integer id, Proveedor proveedorActualizado) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setCodEditorial(proveedorActualizado.getCodEditorial());
            proveedor.setEditorial(proveedorActualizado.getEditorial());
            proveedor.setIsbn(proveedorActualizado.getIsbn());
            proveedor.setTitulo(proveedorActualizado.getTitulo());
            proveedor.setAutor(proveedorActualizado.getAutor());
            proveedor.setCategoria(proveedorActualizado.getCategoria());
            proveedor.setPrecio(proveedorActualizado.getPrecio());
            proveedorRepository.save(proveedor);
            return "Proveedor actualizado con exito";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));
    }

    public String eliminarProveedor(Integer id) {
        return proveedorRepository.findById(id).
                map(existingProveedor -> {
                    proveedorRepository.delete(existingProveedor);
                    return "Proveedor eliminado correctamente";
                }).orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    public void agregarLibro(Libro libro) {
        libroFeignClient.agregarLibro(libro);
    }

}
