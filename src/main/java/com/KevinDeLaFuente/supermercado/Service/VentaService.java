package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    List<Venta> getAllVenta();
    Optional<Venta> getVentaById(Long id);
    Venta createVenta(Venta venta);
    Venta updateVenta(Long id, Venta venta);
    void deleteVenta(Long id);
}