package com.swnat.repository;

import com.swnat.model.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    /**
     * Obtener el listado de colaboradores por alguno de los criterios siguientes:
     * nombre, apellido
     *
     * @return {@link Page <Colaborador>}
     */
    @Query("select p from Colaborador p where concat(nombre,' ',apellido) like %:nombre% or documento like %:documento%")
    Page<Colaborador> findAllByNombreContainsOrApellidoContains(@Param("nombre") String nombre, @Param("documento") String documento, Pageable pageable);

}
