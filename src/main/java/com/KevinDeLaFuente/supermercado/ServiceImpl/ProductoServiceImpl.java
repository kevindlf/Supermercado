package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Producto;
import com.KevinDeLaFuente.supermercado.Repository.ProductoRepository;
import com.KevinDeLaFuente.supermercado.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

   private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
            return productoRepository.findById(id)
                    .map(existingProducto -> {
                        existingProducto.setNombre(producto.getNombre());
                        existingProducto.setPrecio(producto.getPrecio());
                        existingProducto.setFechaElaboracion(producto.getFechaElaboracion());
                        existingProducto.setVencimiento(producto.getVencimiento());
                        existingProducto.setMarca(producto.getMarca());
                        // Agrega cualquier otro campo que necesite ser actualizado
                        return productoRepository.save(existingProducto);
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.findById(id)
                .ifPresent(productoRepository::delete);
    }
}
