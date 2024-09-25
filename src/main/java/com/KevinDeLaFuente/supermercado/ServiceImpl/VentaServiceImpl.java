package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Venta;
import com.KevinDeLaFuente.supermercado.Repository.VentaRepository;
import com.KevinDeLaFuente.supermercado.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    @Autowired
    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> getVentaById(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Long id, Venta venta) {
        return ventaRepository.findById(id)
                .map(existingVenta -> {
                    existingVenta.setFecha(venta.getFecha());

                    existingVenta.setCliente(venta.getCliente());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return ventaRepository.save(existingVenta);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.findById(id)
                .ifPresent(ventaRepository::delete);
    }
}
