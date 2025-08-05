package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.Imovel;
import models.Status;
import models.TipoImovel;

public class Imoveis extends Controller {

    public static void form() {
    	List<TipoImovel> tipo = TipoImovel.findAll();
		render(tipo);
    }
    public static void listar() {
    	List<Imovel> imoveis = Imovel.find("status = ?1", Status.ATIVO).fetch();
		render(imoveis);
	}
	public static void editar(Long id) {
		List<TipoImovel> tipo = TipoImovel.findAll();
		Imovel i = Imovel.findById(id);
		renderTemplate("Imoveis/form.html", i, tipo);
	}	
	public static void salvar(Imovel imovel) {
		// Verifica se já existe um imóvel com o mesmo código de anúncio
	    Imovel existente = Imovel.find("codigoAnuncio = ?1", imovel.codigoAnuncio).first();
	    
	    if (existente != null && (imovel.id == null || !existente.id.equals(imovel.id))) {
	   
	    	List<TipoImovel> tipo = TipoImovel.findAll();
	    	flash.error("Já existe um imóvel com este código de anúncio.");
	        renderTemplate("Imoveis/form.html", imovel, tipo);
	    }
		
		imovel.save();
		listar();
	}	
	public static void remover(Long id) {
		Imovel imovel = Imovel.findById(id);
		imovel.status = Status.INATIVO;
		imovel.save();
		listar();
	}
}