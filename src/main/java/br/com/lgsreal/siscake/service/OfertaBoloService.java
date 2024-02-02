package br.com.lgsreal.siscake.service;

import br.com.lgsreal.siscake.dto.OfertaBoloDTO;
import br.com.lgsreal.siscake.entities.OfertaBolo;
import br.com.lgsreal.siscake.repository.OfertaBoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfertaBoloService {
    private final OfertaBoloRepository ofertaBoloRepository;

    @Autowired
    public OfertaBoloService(OfertaBoloRepository ofertaBoloRepository) {
        this.ofertaBoloRepository = ofertaBoloRepository;
    }

    public Page<OfertaBoloDTO> findAll(Pageable pageable) {
        Page<OfertaBolo> ofertasBolo = ofertaBoloRepository.findAll(pageable);
        return ofertasBolo.map(this::toDTO);
    }

    public OfertaBoloDTO findById(Long id) {
        Optional<OfertaBolo> ofertaBolo = ofertaBoloRepository.findById(id);
        return ofertaBolo.map(this::toDTO).orElse(null);
    }

    public OfertaBoloDTO save(OfertaBoloDTO ofertaBoloDTO) {
        OfertaBolo ofertaBolo = toEntity(ofertaBoloDTO);
        ofertaBolo = ofertaBoloRepository.save(ofertaBolo);
        return toDTO(ofertaBolo);
    }

    public OfertaBoloDTO update(Long id, OfertaBoloDTO ofertaBoloDTO) {
        OfertaBolo ofertaBolo = ofertaBoloRepository.getReferenceById(id);
        ofertaBolo.setColaboradorId(ofertaBoloDTO.id());
        ofertaBolo.setQuantidadeBolos(ofertaBoloDTO.quantidadeBolos());
        ofertaBolo.setDataOferta(ofertaBoloDTO.dataOferta());
        ofertaBolo = ofertaBoloRepository.save(ofertaBolo);
        return toDTO(ofertaBolo);
    }

    public void delete(Long id) {
        ofertaBoloRepository.deleteById(id);
    }

    private OfertaBoloDTO toDTO(OfertaBolo ofertaBolo) {
        return new OfertaBoloDTO(
                ofertaBolo.getId(),
                ofertaBolo.getColaboradorId(),
                ofertaBolo.getQuantidadeBolos(),
                ofertaBolo.getDataOferta()
        );
    }

    private OfertaBolo toEntity(OfertaBoloDTO ofertaBoloDTO) {
        return new OfertaBolo(
                ofertaBoloDTO.id(),
                ofertaBoloDTO.colaboradorId(),
                ofertaBoloDTO.quantidadeBolos(),
                ofertaBoloDTO.dataOferta()
        );
    }
}
