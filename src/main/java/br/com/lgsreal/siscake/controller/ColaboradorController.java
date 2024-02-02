package br.com.lgsreal.siscake.controller;

import br.com.lgsreal.siscake.dto.ColaboradorDTO;
import br.com.lgsreal.siscake.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<Page<ColaboradorDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable
            ) {
        Page<ColaboradorDTO> colaboradoresDTO = colaboradorService.findAll(pageable);
        return ResponseEntity.ok(colaboradoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> findById(@PathVariable Long id) {
        ColaboradorDTO colaboradorDTO = colaboradorService.findById(id);
        return ResponseEntity.ok(colaboradorDTO);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> save(@Valid @RequestBody ColaboradorDTO colaboradorDTO) {
        ColaboradorDTO savedColaborador = colaboradorService.save(colaboradorDTO);
        return new ResponseEntity<>(savedColaborador, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> update(@Valid @PathVariable Long id, @RequestBody ColaboradorDTO colaboradorDTO) {
        ColaboradorDTO updatedColaborador = colaboradorService.update(id, colaboradorDTO);
        return ResponseEntity.ok(updatedColaborador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
