package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.entity.Libro;
import pe.cibertec.model.Proveedor;
import pe.cibertec.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/api/ms-proveedor")
public class ProveedorController {

	@Autowired
    ProveedorService proveedorService;

    @GetMapping("/listProveedores")
    public ResponseEntity<List<Proveedor>> obtenerTodos() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    @GetMapping("/proveedor/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorService.obtenerProveedorPorId(id));
    }

    @PostMapping("/agregarProveedor")
    public void agregar(@RequestBody Proveedor proveedor) {
        proveedorService.agregarProveedor(proveedor);
    }

    @PutMapping("/actualizarProveedor/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.actualizarProveedor(id, proveedor));
    }

    @DeleteMapping("/eliminarProveedor/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorService.eliminarProveedor(id));
    }

    @PostMapping("/agregarLibro")
    public void agregar(@RequestBody Libro libro) {
        proveedorService.agregarLibro(libro);
    }

}

