package br.com.lgsreal.siscake.service;

import br.com.lgsreal.siscake.dto.ColaboradorDTO;
import br.com.lgsreal.siscake.entities.Colaborador;
import br.com.lgsreal.siscake.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Page<ColaboradorDTO> findAll(Pageable pageable) {
        Page<Colaborador> colaboradores = colaboradorRepository.findAll(pageable);
        return colaboradores.map(this::toDTO);
    }

    public ColaboradorDTO findById(Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        return colaborador.map(this::toDTO).orElse(null);
    }

    public ColaboradorDTO save(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = toEntity(colaboradorDTO);
        colaborador = colaboradorRepository.save(colaborador);
        return toDTO(colaborador);
    }

    public ColaboradorDTO update(Long id, ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorRepository.getReferenceById(id);
        colaborador.setNome(colaboradorDTO.nome());
        colaborador.setEmail(colaboradorDTO.email());
        colaborador.setDataNascimento(colaboradorDTO.dataNascimento());
        colaborador.setDepartamento(colaboradorDTO.departamento());
        colaborador.setContadorOfertaBolos(colaboradorDTO.contadorOfertaBolos());
        colaborador = colaboradorRepository.save(colaborador);
        return toDTO(colaborador);
    }

    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }

    private ColaboradorDTO toDTO(Colaborador colaborador) {
        return new ColaboradorDTO(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getEmail(),
                colaborador.getDataNascimento(),
                colaborador.getDepartamento(),
                colaborador.getContadorOfertaBolos()
                );
    }

    private Colaborador toEntity(ColaboradorDTO colaboradorDTO) {
        return new Colaborador(
                colaboradorDTO.id(),
                colaboradorDTO.nome(),
                colaboradorDTO.email(),
                colaboradorDTO.dataNascimento(),
                colaboradorDTO.departamento(),
                colaboradorDTO.contadorOfertaBolos()
        );
    }
}
