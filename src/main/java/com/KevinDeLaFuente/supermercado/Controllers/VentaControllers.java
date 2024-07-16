package com.KevinDeLaFuente.supermercado.Controllers;

import com.KevinDeLaFuente.supermercado.Models.Venta;
import com.KevinDeLaFuente.supermercado.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaControllers {
    @Autowired
    VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVenta() {
        return ResponseEntity.ok(ventaService.getAllVenta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.createVenta(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.updateVenta(id, venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}
