package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Sucursal;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<Sucursal> getAllSucursal();
    Optional<Sucursal> getSucursalById(Long id);
    Sucursal createSucursal(Sucursal sucursal);
    Sucursal updateSucursal(Long id, Sucursal sucursal);
    void deleteSucursal(Long id);
}