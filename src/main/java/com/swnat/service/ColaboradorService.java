package com.swnat.service;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Colaborador;

public interface ColaboradorService extends IGenericService<Colaborador, Long> {

    /**
     * Trae los registros que entren en el filtro
     * @param filter
     * @param page
     * @param size
     * @return
     */
    PaginationResponse<Colaborador> findByFilter(String filter, int page, int size);

}
