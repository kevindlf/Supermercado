package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Sucursal;
import com.KevinDeLaFuente.supermercado.Repository.SucursalRepository;
import com.KevinDeLaFuente.supermercado.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public List<Sucursal> getAllSucursal() {
        return sucursalRepository.findAll();
    }

    @Override
    public Optional<Sucursal> getSucursalById(Long id) {
        return sucursalRepository.findById(id);
    }

    @Override
    public Sucursal createSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal updateSucursal(Long id, Sucursal sucursal) {
        return sucursalRepository.findById(id)
                .map(existingSucursal -> {
                    existingSucursal.setNombre(sucursal.getNombre());
                    existingSucursal.setUbicación(sucursal.getUbicación());
                    existingSucursal.setEmail(sucursal.getEmail());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return sucursalRepository.save(existingSucursal);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoría not found"));
    }

    @Override
    public void deleteSucursal(Long id) {
        sucursalRepository.findById(id)
                .ifPresent(sucursalRepository::delete);
    }

}
