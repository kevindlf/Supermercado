package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Long id, Categoria categoria);
    void deleteCategoria(Long id);
}
