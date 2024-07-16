package com.KevinDeLaFuente.supermercado.Repository;

import com.KevinDeLaFuente.supermercado.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
