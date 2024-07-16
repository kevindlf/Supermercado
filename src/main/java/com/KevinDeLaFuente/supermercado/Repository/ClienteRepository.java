package com.KevinDeLaFuente.supermercado.Repository;

import com.KevinDeLaFuente.supermercado.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
