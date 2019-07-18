package br.com.tlmacedo.cafeperfeito.nfe;

import br.com.tlmacedo.cafeperfeito.model.vo.enums.RelatorioTipo;
import br.com.tlmacedo.cafeperfeito.service.ServiceRelatorio;
import net.sf.jasperreports.engine.JRException;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-05-07
 * Time: 19:01
 */

public class ServiceImprimeDanfe {

    public void imprimeDanfe(File arquivoXml) {
        try {
            new ServiceRelatorio().gerar(RelatorioTipo.NFE, arquivoXml);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
