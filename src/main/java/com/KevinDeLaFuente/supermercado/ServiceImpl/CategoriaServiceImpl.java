package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Categoria;
import com.KevinDeLaFuente.supermercado.Repository.CategoriaRepository;
import com.KevinDeLaFuente.supermercado.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(existingCategoria -> {
                    existingCategoria.setNombre(categoria.getNombre());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return categoriaRepository.save(existingCategoria);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.findById(id)
                .ifPresent(categoriaRepository::delete);
    }
}
