package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Sucursal;
import com.KevinDeLaFuente.supermercado.Repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SucursalService {

    @Autowired
    SucursalRepository sucursalrepository;

    public List<Sucursal> getAllSucursales() {
        return sucursalrepository.findAll();
    }

    public Optional<Sucursal> getSucursalById(Long id) {
        return sucursalrepository.findById(id);
    }

    public void saveSucursal(Sucursal sucursal) {
        sucursalrepository.save(sucursal);
    }

    public void deleteSucursal(Long id) {
        sucursalrepository.deleteById(id);
    }

    public void updateSucursal(Long id, Sucursal sucursal) {
        if (sucursalrepository.existsById(id)) {
            sucursal.setId(id);
            sucursalrepository.save(sucursal);
        }
    }



}
