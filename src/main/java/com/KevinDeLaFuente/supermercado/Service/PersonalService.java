package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Personal;

import java.util.List;
import java.util.Optional;

public interface PersonalService {
    List<Personal> getAllPersonal();
    Optional<Personal> getPersonalById(Long id);
    Personal createPersonal(Personal personal);
    Personal updatePersonal(Long id, Personal personal);
    void deletePersonal(Long id);
}
