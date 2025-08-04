package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.Imovel;
import models.Status;

public class Imoveis extends Controller {

    public static void form() {
        render();
    }
    public static void listar(String termo) {
		List<Imovel> imoveis = null;	
		render(imoveis);
	}
	public static void detalhar(Imovel imovel) {
		render(imovel);
	}
	public static void editar(Long id) {
		Imovel i = Imovel.findById(id);
		renderTemplate("Imoveis/form.html", i);
	}	
	public static void salvar(Imovel imovel) {
		imovel.save();
	}	
	public static void remover(Long id) {
		Imovel imovel = Imovel.findById(id);
		imovel.status = Status.INATIVO;
		imovel.save();
		listar(null);
	}
}