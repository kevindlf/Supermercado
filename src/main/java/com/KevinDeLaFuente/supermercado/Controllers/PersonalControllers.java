package com.KevinDeLaFuente.supermercado.Controllers;

import com.KevinDeLaFuente.supermercado.Models.Personal;
import com.KevinDeLaFuente.supermercado.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalControllers {
    @Autowired
    PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<Personal>> getAllPersonal() {
        return ResponseEntity.ok(personalService.getAllPersonal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        return personalService.getPersonalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal) {
        return personalService.createPersonal(personal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        return ResponseEntity.ok(personalService.updatePersonal(id, personal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        personalService.deletePersonal(id);
        return ResponseEntity.noContent().build();
    }

}
