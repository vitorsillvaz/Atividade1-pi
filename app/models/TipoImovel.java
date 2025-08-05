package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
@Entity
public class TipoImovel extends Model {
	public String descricao;

	public TipoImovel(String descricao) {
		this.descricao = descricao;
	}

	public TipoImovel() {
		
	}

	@Override
	public String toString() {
		return "TipoImovel [descricao=" + descricao + "]";
	}
	
	
}
