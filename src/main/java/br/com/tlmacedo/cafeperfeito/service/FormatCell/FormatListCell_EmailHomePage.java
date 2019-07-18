package br.com.tlmacedo.cafeperfeito.service.FormatCell;

import br.com.tlmacedo.cafeperfeito.model.vo.EmailHomePage;
import br.com.tlmacedo.cafeperfeito.model.vo.enums.FinalidadeEmailTelefone;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-03-20
 * Time: 15:30
 */

public class FormatListCell_EmailHomePage extends ListCell<EmailHomePage> {
    private ImageView imageView = new ImageView();

    public FormatListCell_EmailHomePage() {
    }

    @Override
    protected void updateItem(EmailHomePage item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            HBox hBox = new HBox();
            hBox.setSpacing(4);
            switch (item.getTipo()) {
                case HOMEPAGE:
                    imageView = new ImageView();
                    imageView.setImage(new Image("image/ico/ic_home_page_dp16.png"));
                    hBox.getChildren().add(imageView);
                    break;
                case EMAIL:
                    for (int value : item.getFinalidade().chars().map(Character::getNumericValue).toArray()) {
                        FinalidadeEmailTelefone finalidade = FinalidadeEmailTelefone.toEnum(value);
                        imageView = new ImageView();
                        switch (finalidade) {
                            case PRINCIPAL:
                                imageView.setImage(new Image("image/ico/ic_email_principal_dp16.png"));
                                break;
                            case NFE:
                                imageView.setImage(new Image("image/ico/ic_email_nfe_dp16.png"));
                                break;
                            default:
                                //imageView.setImage(new Image("image/ico/ic_home_page_dp16.png"));
                                imageView.setImage(new Image("image/ico/ic_email_dp16.png"));
                                break;
                        }
                        hBox.getChildren().add(imageView);
                    }
                    break;
            }
//            try {
//                if (item.getTipo().equals(WebTipo.EMAIL))
//                    imageView.setImage(new Image(ServiceVariaveisSistema.PATHICONE + "ic_email@_dp14.png"));
//                else
//                    imageView.setImage(new Image(ServiceVariaveisSistema.PATHICONE + "ic_webhome_dp14.png"));
//                hBox.getChildren().add(imageView);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
            setGraphic(hBox);
            setText(item.toString());
        }
    }

}
