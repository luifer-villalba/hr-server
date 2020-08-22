package com.swnat.service;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Colaborador;
import com.swnat.repository.ColaboradorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColaboradorServiceImpl extends GenericService<Colaborador, Long> implements ColaboradorService {

    private ColaboradorRepository colaboradorRepository;

    public ColaboradorServiceImpl(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    @Override
    public JpaRepository<Colaborador, Long> getRepository() {
        return this.colaboradorRepository;
    }

    @Override
    public PaginationResponse<Colaborador> findByFilter(String filter, int page, int size) {
        Page<Colaborador> searchResult;
        PageRequest pageRequest = PageRequest.of(page, size);

        if (filter == null || filter.isEmpty()) {
            searchResult = colaboradorRepository.findAll(pageRequest);
        } else {
            searchResult = colaboradorRepository.findAllByNombreContainsOrApellidoContains(filter, filter, pageRequest);
        }

        PaginationResponse<Colaborador> response = new PaginationResponse<>();
        response.setContent(searchResult.getContent());
        response.setTotalCount(searchResult.getTotalElements());
        return response;
    }

}
