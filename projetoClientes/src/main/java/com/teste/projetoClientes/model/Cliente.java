package com.teste.projetoClientes.model;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "cliente")
@Component
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String tipo;
    
    private String cpfCnpj;
    
    private String rgIe;
    
    private String dataCadastro;
    
    private boolean ativo;
    
    @ElementCollection
    private List<String> telefones;

    
    public Cliente() {
    }
    
   
    
    public Cliente(Long id, String nome, String tipo, String cpfCnpj, String rgIe, String dataCadastro, boolean ativo,
			List<String> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.telefones = telefones;
	}



	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public String getRgIe() {
        return rgIe;
    }
    
    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }
    
    public String getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }



	public List<String> getTelefones() {
		return telefones;
	}



	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
    
    
    
}
