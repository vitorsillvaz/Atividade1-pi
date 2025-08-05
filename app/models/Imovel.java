package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import play.db.jpa.Model;

@Entity
public class Imovel extends Model {
	public Integer codigoAnuncio;
	public String bairro;
	public Integer quantidadeComodos;
	public double areaInterna;
	public double areaExterna;
	
	@ManyToOne
	public TipoImovel tipoImovel;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Transient //serve para que o campo não seja salvo no banco
	public double getAreaTotal() {
	        return areaInterna + areaExterna;
	}
	
	public Imovel() {
		this.status = Status.ATIVO;
	}
	
	public Imovel(Integer codigoAnuncio, String bairro, Integer quantidadeComodos, double areaInterna,
			double areaExterna, TipoImovel tipoImovel, Status status) {
		this.codigoAnuncio = codigoAnuncio;
		this.bairro = bairro;
		this.quantidadeComodos = quantidadeComodos;
		this.areaInterna = areaInterna;
		this.areaExterna = areaExterna;
		this.tipoImovel = tipoImovel;
		this.status = status;
	}
}
