package br.com.lgsreal.siscake.entities;

import jakarta.persistence.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="arquivo_pdf")
public class ArquivoPDF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private File arquivo;
    private LocalDate dataUpload;
    private String categoria;
    private LocalDate dataEncerramento;

    public ArquivoPDF() {}

    public ArquivoPDF(Long id, File arquivo, LocalDate dataUpload, String categoria, LocalDate dataEncerramento) {
        this.id = id;
        this.arquivo = arquivo;
        this.dataUpload = dataUpload;
        this.categoria = categoria;
        this.dataEncerramento = dataEncerramento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public LocalDate getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDate dataUpload) {
        this.dataUpload = dataUpload;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArquivoPDF that = (ArquivoPDF) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArquivoPDF{" +
                "id=" + id +
                ", arquivo=" + arquivo +
                ", dataUpload=" + dataUpload +
                ", categoria='" + categoria + '\'' +
                ", dataEncerramento=" + dataEncerramento +
                '}';
    }
}
