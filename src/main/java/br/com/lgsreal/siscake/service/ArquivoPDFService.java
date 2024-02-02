package br.com.lgsreal.siscake.service;

import br.com.lgsreal.siscake.dto.ArquivoPDFDTO;
import br.com.lgsreal.siscake.entities.ArquivoPDF;
import br.com.lgsreal.siscake.repository.ArquivoPDFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArquivoPDFService {
    private final ArquivoPDFRepository arquivoPDFRepository;

    @Autowired
    public ArquivoPDFService(ArquivoPDFRepository arquivoPDFRepository){
        this.arquivoPDFRepository = arquivoPDFRepository;
    }

    public ArquivoPDFDTO save(ArquivoPDFDTO arquivoPDFDTO) {
        ArquivoPDF arquivoPDF = toEntity(arquivoPDFDTO);
        arquivoPDF = arquivoPDFRepository.save(arquivoPDF);
        return toDTO(arquivoPDF);
    }
    private ArquivoPDFDTO toDTO(ArquivoPDF arquivoPDF) {
        return new ArquivoPDFDTO(
                arquivoPDF.getId(),
                arquivoPDF.getArquivo(),
                arquivoPDF.getDataUpload(),
                arquivoPDF.getCategoria(),
                arquivoPDF.getDataEncerramento()
        );
    }

    private ArquivoPDF toEntity(ArquivoPDFDTO arquivoPDFDTO) {
        return new ArquivoPDF(
                arquivoPDFDTO.id(),
                arquivoPDFDTO.arquivo(),
                arquivoPDFDTO.dataUpload(),
                arquivoPDFDTO.categoria(),
                arquivoPDFDTO.dataEncerramento()
        );
    }

}
