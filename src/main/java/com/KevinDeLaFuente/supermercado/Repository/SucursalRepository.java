package com.KevinDeLaFuente.supermercado.Repository;

import com.KevinDeLaFuente.supermercado.Models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository <Sucursal, Long> {

}
