package com.example.aprovechapp.entity;

import java.awt.Point;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.example.aprovechapp.enums.TipoDeVerduleria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Verduleria {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private UUID id;
  private String nombre;
  private String numeroDeTelefono;
  private TipoDeVerduleria tipoDeVerduleria;

  // Un administrador puede tener muchas verdulerias
  @ManyToOne
  @JoinColumn(name = "administrador_id")
  private Administrador administrador;

  private double latitud;
  private double longitud;
  // Una verdulería puede tener muchos horarios
  @OneToMany(mappedBy = "verduleria")
  private List<Horario> horarios;
  // Una verdulería puede tener muchas ofertas
  @OneToMany(mappedBy = "verduleria")
  private List<Oferta> ofertas;
}
