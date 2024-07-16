package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Proveedores;

import java.util.List;
import java.util.Optional;

public interface ProveedoresService {
    List<Proveedores> getAllProveedores();
    Optional<Proveedores> getProveedoresById(Long id);
    Proveedores createProveedores(Proveedores proveedores);
    Proveedores updateProveedores(Long id, Proveedores proveedores);
    void deleteProveedores(Long id);
}