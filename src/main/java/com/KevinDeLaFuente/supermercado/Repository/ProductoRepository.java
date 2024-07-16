package com.KevinDeLaFuente.supermercado.Repository;

import com.KevinDeLaFuente.supermercado.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
