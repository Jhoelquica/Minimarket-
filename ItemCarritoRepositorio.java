package repositorio;

import modelo.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarritoRepositorio extends JpaRepository<ItemCarrito, Long> {
    // Obtener todos los items en el carrito por cliente
    List<ItemCarrito> findByClienteId(Long clienteId);

    // Verificar si un cliente tiene el mismo producto en el carrito
    boolean existsByClienteIdAndProductoId(Long clienteId, Long productoId);

    // Obtener el carrito de un cliente y producto específico
    ItemCarrito findByClienteIdAndProductoId(Long clienteId, Long productoId);
}
