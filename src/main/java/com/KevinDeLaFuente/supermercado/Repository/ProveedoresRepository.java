package com.KevinDeLaFuente.supermercado.Repository;

import com.KevinDeLaFuente.supermercado.Models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
}
