package br.com.lgsreal.siscake.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="oferta_bolo")
public class OfertaBolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long colaboradorId;
    private int quantidadeBolos;
    private LocalDate dataOferta;

    public OfertaBolo() {}

    public OfertaBolo(Long id, Long colaboradorId, int quantidadeBolos, LocalDate dataOferta) {
        this.id = id;
        this.colaboradorId = colaboradorId;
        this.quantidadeBolos = quantidadeBolos;
        this.dataOferta = dataOferta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public int getQuantidadeBolos() {
        return quantidadeBolos;
    }

    public void setQuantidadeBolos(int quantidadeBolos) {
        this.quantidadeBolos = quantidadeBolos;
    }

    public LocalDate getDataOferta() {
        return dataOferta;
    }

    public void setDataOferta(LocalDate dataOferta) {
        this.dataOferta = dataOferta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfertaBolo that = (OfertaBolo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OfertaBolo{" +
                "id=" + id +
                ", colaboradorId=" + colaboradorId +
                ", quantidadeBolos=" + quantidadeBolos +
                ", dataOferta=" + dataOferta +
                '}';
    }
}
