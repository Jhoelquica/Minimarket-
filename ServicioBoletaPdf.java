package servicio;

import modelo.BoletaPdf;
import modelo.Venta;
import repositorio.BoletaPdfRepositorio;
import repositorio.VentaRepositorio;
import excepcion.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBoletaPdf {

    private final BoletaPdfRepositorio boletaPdfRepositorio;
    private final VentaRepositorio ventaRepositorio;

    public ServicioBoletaPdf(BoletaPdfRepositorio boletaPdfRepositorio, VentaRepositorio ventaRepositorio) {
        this.boletaPdfRepositorio = boletaPdfRepositorio;
        this.ventaRepositorio = ventaRepositorio;
    }

    public BoletaPdf crearBoleta(BoletaPdf boleta, Long ventaId) {
        Venta venta = ventaRepositorio.findById(ventaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Venta no encontrada con id " + ventaId));
        boleta.setVenta(venta);
        return boletaPdfRepositorio.save(boleta);
    }

    public BoletaPdf obtenerPorId(Long id) {
        return boletaPdfRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Boleta no encontrada con id " + id));
    }

    public List<BoletaPdf> listarTodas() {
        return boletaPdfRepositorio.findAll();
    }

    public BoletaPdf actualizarBoleta(Long id, BoletaPdf datosBoleta) {
        BoletaPdf boleta = obtenerPorId(id);
        boleta.setArchivoPdf(datosBoleta.getArchivoPdf());
        return boletaPdfRepositorio.save(boleta);
    }

    public void eliminarBoleta(Long id) {
        BoletaPdf boleta = obtenerPorId(id);
        boletaPdfRepositorio.delete(boleta);
    }
}
