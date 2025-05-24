package mapeador;

import dto.ProductoDTO;
import modelo.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapeador {

    public ProductoDTO toDTO(Producto producto) {
        if (producto == null) return null;
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setProveedorId(producto.getProveedor() != null ? producto.getProveedor().getId() : null);
        return dto;
    }

    public Producto toEntidad(ProductoDTO dto) {
        if (dto == null) return null;
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        // Para proveedor, setear manualmente en servicio si es necesario
        return producto;
    }
}
