package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findPabellonesByNombre(String nombre);

}
