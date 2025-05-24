package controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {

    @PostMapping("/registro")
    public ResponseEntity<?> registrarCliente(@RequestBody /*ClienteDTO*/ Object clienteDto) {
        // Registrar cliente
        return ResponseEntity.ok("Cliente registrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Long id, @RequestBody /*ClienteDTO*/ Object clienteDto) {
        // Actualizar cliente por id
        return ResponseEntity.ok("Cliente actualizado");
    }
}
