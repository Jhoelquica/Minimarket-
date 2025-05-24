package repositorio;

import modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    // Buscar cliente por su email
    Optional<Cliente> findByEmail(String email);

    // Verificar si el cliente existe por teléfono
    boolean existsByTelefono(String telefono);
}
