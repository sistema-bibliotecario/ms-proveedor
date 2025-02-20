package pe.cibertec.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.cibertec.entity.Libro;

@FeignClient(name = "ms-libro", url = "http://localhost:9002")
public interface ILibroFeignClient {

    @GetMapping("/api/ms-libro/agregarLibro")
    void agregarLibro(@RequestBody Libro libro);
}
