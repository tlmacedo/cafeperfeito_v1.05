package br.com.tlmacedo.cafeperfeito.nfe;

import br.com.tlmacedo.cafeperfeito.model.vo.enums.RelatorioTipo;
import br.com.tlmacedo.cafeperfeito.service.ServiceRelatorio;
import net.sf.jasperreports.engine.JRException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-05-07
 * Time: 19:01
 */

public class ServiceImprimeDanfe {

//    Recebimento recebimento;
//
//    public Recebimento getRecebimento() {
//        return recebimento;
//    }
//
//    public void setRecebimento(Recebimento recebimento) {
//        this.recebimento = recebimento;
//    }
//
//    public void setNumeroRecibo(Recebimento recebimento) {
//        setRecebimento(recebimento);
//        setNumeroRecibo();
//    }
//    private void setNumeroRecibo() {
//        String documentoRec =
//                String.format("%04d%02d%02d%02d",
//                        getRecebimento().dtCadastroProperty().get().getYear(),
//                        getRecebimento().dtCadastroProperty().get().getMonthValue(),
//                        getRecebimento().dtCadastroProperty().get().getDayOfMonth(),
//                        new RecebimentoDAO().getAll(Recebimento.class,
//                                null,
//                                "dtCadastro",
//                                "between",
////                                "1"
//                                String.format("'%s %s' and '%s %s'",
//                                        getRecebimento().dtCadastroProperty().get().format(DTF_MYSQL_DATA),
//                                        "00:00:00",
//                                        getRecebimento().dtCadastroProperty().get().format(DTF_MYSQL_DATA),
//                                        "23:59:59"
//                                )
//                        ).stream()
//                                .filter(rec -> !rec.getDocumento().equals(""))
//                                .count() + 1);
//        getRecebimento().setDocumento(documentoRec);
//        setRecebimento(new RecebimentoDAO().persiste(getRecebimento()));
//    }

    public void imprimeDanfe(File arquivoXml) {
//        setRecebimento(recebimento);
//        if (getRecebimento().getDocumento() == null || getRecebimento().getDocumento().equals(""))
//            setNumeroRecibo();
//        getRecebimento().setEmissorRecibo(LogadoInf.getLojaUser());
//
//        List list = new ArrayList();
//        list.add(getRecebimento());
//
//        final String[] descProduto = new String[1];
//        int qtd = getRecebimento().getContasAReceber().getSaidaProduto().getSaidaProdutoProdutoList().stream()
//                .filter(produto -> {
//                    if (produto.getDescricao().toLowerCase().contains("supremo")) {
//                        descProduto[0] = produto.getDescricao();
//                        return true;
//                    }
//                    return false;
//                })
//                .mapToInt(SaidaProdutoProduto::getQtd)
//                .reduce(0, (left, right) -> left + right);
//
        Map paramentros = new HashMap();
//        paramentros.put("valorExtenso", new ServiceNumeroExtenso(getRecebimento().valorProperty().get()).toString());
//        paramentros.put("referenteA", String.format("%02d KG de %s\n", qtd, descProduto[0]));
        try {
            new ServiceRelatorio().gerar(RelatorioTipo.RECIBO, paramentros, arquivoXml);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
