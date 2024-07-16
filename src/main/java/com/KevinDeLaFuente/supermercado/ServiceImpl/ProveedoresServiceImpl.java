package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Proveedores;
import com.KevinDeLaFuente.supermercado.Repository.ProveedoresRepository;
import com.KevinDeLaFuente.supermercado.Service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    private final ProveedoresRepository proveedoresRepository;

    @Autowired
    public ProveedoresServiceImpl(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Optional<Proveedores> getProveedoresById(Long id) {
        return proveedoresRepository.findById(id);
    }

    @Override
    public Proveedores createProveedores(Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Long id, Proveedores proveedores) {
        return proveedoresRepository.findById(id)
                .map(existingProveedores -> {
                    existingProveedores.setNombre(proveedores.getNombre());
                    existingProveedores.setContacto(proveedores.getContacto());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return proveedoresRepository.save(existingProveedores);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));

    }

    @Override
    public void deleteProveedores(Long id) {
        proveedoresRepository.findById(id)
                .ifPresent(proveedoresRepository::delete);
    }
}
