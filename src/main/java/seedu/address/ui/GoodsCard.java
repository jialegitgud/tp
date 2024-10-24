package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.goodsreceipt.GoodsReceipt;

/**
 * A UI component that displays information of a {@code GoodsReceipt}
 */
public class GoodsCard extends UiPart<Region> {

    private static final String FXML = "GoodsListCard.fxml";

    public final GoodsReceipt goodsReceipt;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label goodsName;
    @FXML
    private Label goodsCategory;
    @FXML
    private Label supplierName;
    @FXML
    private Label procurementDate;
    @FXML
    private Label arrivalDate;
    @FXML
    private Label isDelivered;
    @FXML
    private Label quantity;
    @FXML
    private Label price;


    /**
     * Creates a {@code GoodsCard} with the given {@code GoodsReceipt} and index to display.
     */
    public GoodsCard(GoodsReceipt goodsReceipt, int displayedIndex) {
        super(FXML);
        this.goodsReceipt = goodsReceipt;
        id.setText(displayedIndex + ". ");
        goodsName.setText(goodsReceipt.getGoods().getReadableGoodsName());
        goodsCategory.setText(goodsReceipt.getGoods().getCategory().toString());
        supplierName.setText(goodsReceipt.getSupplierName().toString());
        procurementDate.setText(goodsReceipt.getProcurementDate().toString());
        arrivalDate.setText(goodsReceipt.getArrivalDate().toString());
        isDelivered.setText(goodsReceipt.isDelivered() ? "Delivered" : "Undelivered");
        quantity.setText(String.valueOf(goodsReceipt.getQuantity()));
        price.setText(String.valueOf(goodsReceipt.getPriceTotal()));
    }
}
