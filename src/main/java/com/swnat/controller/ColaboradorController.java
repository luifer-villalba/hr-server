package com.swnat.controller;

import com.swnat.dto.PaginationResponse;
import com.swnat.model.Colaborador;
import com.swnat.service.ColaboradorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author luifer
 * @version 1.0
 * @since 23-08-2020
 */
@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @ApiOperation(value = "Obtener lista de colaboradores", notes = "Obtener lista de colaboradores filtrando con un texto y devolviendo paginado")
    @GetMapping("/")
    public PaginationResponse<Colaborador> getAllColaborador(@RequestParam(value = "filter", required = false) String filter, @RequestParam("page") int page, @RequestParam("size") int size) {
        return colaboradorService.findByFilter(filter, page, size);
    }

    @ApiOperation(value = "Crear un colaborador", notes = "Crea un nuevo colaborador.")
    @PostMapping("/")
    public Colaborador saveColaborador(@Valid @RequestBody Colaborador colaborador) {
        return colaboradorService.add(colaborador);
    }

    @ApiOperation(value = "Editar un colaborador", notes = "Actualiza datos de un colaborador ya existente.")
    @PutMapping("/{id}")
    public Colaborador updateColaborador(@Valid @RequestBody Colaborador colaborador, @PathVariable Long id) {
        return colaboradorService.update(id, colaborador);
    }

    @ApiOperation(value = "Obtener un colaborador", notes = "Obtiene un colaborador.")
    @GetMapping("/{id}")
    public Colaborador getColaborador(@PathVariable Long id) {
        return colaboradorService.getOne(id);
    }
    
}
