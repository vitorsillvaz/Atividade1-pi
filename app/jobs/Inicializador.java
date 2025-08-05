package jobs;

import java.util.Date;
import models.Imovel;
import models.Status;
import models.TipoImovel;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	@Override
	public void doJob() throws Exception {
		if (TipoImovel.count() == 0) {
			TipoImovel casa = new TipoImovel("Casa");
			casa.save();
			
			TipoImovel apartamento = new TipoImovel("Apartamento");
			apartamento.save();
			
			TipoImovel chale = new TipoImovel("Chalé");
			chale.save();
			
			Imovel casa1 = new Imovel();
			casa1.codigoAnuncio = 111;
			casa1.bairro = "Rocas";
			casa1.quantidadeComodos = 5;
			casa1.areaInterna = 70;
			casa1.areaExterna = 80;
			casa1.tipoImovel = casa;
			casa1.status = Status.ATIVO;
			casa1.save();
			
		}
			
			
	}

}
