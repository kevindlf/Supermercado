package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Cliente;
import com.KevinDeLaFuente.supermercado.Repository.ClienteRepository;
import com.KevinDeLaFuente.supermercado.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setApellido(cliente.getApellido());
                    existingCliente.setEmail(cliente.getEmail());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return clienteRepository.save(existingCliente);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.findById(id)
                .ifPresent(clienteRepository::delete);

    }

}
