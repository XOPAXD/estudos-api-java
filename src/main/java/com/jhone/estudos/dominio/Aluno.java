package com.jhone.estudos.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Aluno implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private String comentario;

    @OneToMany
    private Set<Tecnologias> tecnologias;



    public Aluno() {
    }

    public Aluno(Integer id, String nome, String email, LocalDateTime data, String comentario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data = data;
        this.comentario = comentario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
