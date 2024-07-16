package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllCliente();
    Optional<Cliente> getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}