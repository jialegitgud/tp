package seedu.address.model.goodsReceipt;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.storage.CsvConverters.GoodsConverter;
import static seedu.address.storage.CsvConverters.GoodsDateConverter;
import static seedu.address.storage.CsvConverters.PersonNameConverter;

import java.time.LocalDateTime;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;

import seedu.address.model.goods.Goods;
import seedu.address.model.person.Name;


/**
 * The {@code GoodsReceipt} class represents the receipt of goods from a supplier
 * Guarantees: Immutable;
 */
public class GoodsReceipt {

    @CsvCustomBindByName(column = "Goods", converter = GoodsConverter.class, required = true)
    private final Goods goods;

    @CsvCustomBindByName(column = "Supplier Name", converter = PersonNameConverter.class, required = true)
    private final Name supplierName;

    @CsvCustomBindByName(column = "Procurement Date", converter = GoodsDateConverter.class, required = true)
    @CsvDate(value = "yyyy-MM-dd HH:mm")
    private final Date procurementDate;

    @CsvCustomBindByName(column = "Arrival Date", converter = GoodsDateConverter.class, required = true)
    @CsvDate(value = "yyyy-MM-dd HH:mm")
    private final Date arrivalDate;

    @CsvBindByName(column = "Is Delivered", required = true)
    private final boolean isDelivered;

    @CsvBindByName(column = "Quantity", required = true)
    @CsvNumber(value = "#")
    private final int quantity;

    @CsvBindByName(column = "Price", required = true)
    @CsvNumber(value = "0.00")
    private final double price;

    /**
     * Constructs a {@code GoodsReceipt}.
     * For use in Csv files. Empty constructor is required for CsvBeanReader.
     */
    public GoodsReceipt() {
        this.goods = null;
        this.supplierName = null;
        this.procurementDate = null;
        this.arrivalDate = null;
        this.isDelivered = false;
        this.quantity = 0;
        this.price = 0.0;
    }

    /**
     * Constructs a {@code GoodsReceipt}.
     *
     * @param goods The goods associated with this receipt.
     * @param supplierName The name of the supplier.
     * @param procurementDate The date when the goods were procured.
     * @param arrivalDate The date when the goods are expected to or have arrived.
     * @param isDelivered A boolean indicating whether the goods have been delivered.
     * @param quantity The quantity of goods in this receipt.
     * @param price The price of the goods in this receipt.
     */
    public GoodsReceipt(Goods goods, Name supplierName, Date procurementDate, Date arrivalDate,
                        boolean isDelivered, int quantity, double price) {
        requireAllNonNull(goods, quantity, procurementDate, arrivalDate, isDelivered);
        checkArgument(isValidProcurementDate(procurementDate));
        this.supplierName = supplierName;
        this.goods = goods;
        this.procurementDate = procurementDate;
        this.arrivalDate = arrivalDate;
        this.isDelivered = isDelivered;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Returns True if the procurement date is valid.
     */
    public static boolean isValidProcurementDate(Date date) {
        return date.getDateTime().isBefore(LocalDateTime.now());
    }

    /**
     * Returns True if supplier is valid
     */
    public boolean isFromSupplier(Name supplier) {
        requireNonNull(supplier);
        return supplierName.equals(supplier);
    }

    /**
     * Returns quantity of the goods.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns if goods are delivered
     */
    public boolean isDelivered() { return isDelivered; }

    /**
     * Returns goods.
     */
    public Goods getGoods() {
        return this.goods;
    }

    /**
     * Returns total price of the goods.
     */
    public double getPriceTotal() {
        return this.quantity * this.price;
    }

    /**
     * Return a new goods object with the new delivery status.
     */
    public GoodsReceipt markAsDelivered() {
        return new GoodsReceipt(this.goods, this.supplierName, this.procurementDate, this.arrivalDate, true,
                this.quantity, this.price);
    }

    /**
     * Format goods as text for viewing.
     */
    @Override
    public String toString() {
        String deliveryStatus = this.isDelivered ? "Delivered" : "Pending";
        return String.format("[Quantity %d] %s (%s)", this.quantity, this.goods.toString(), deliveryStatus);
    }

}