package seedu.address.model.goodsReceipt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.goods.Goods;
import seedu.address.model.goods.GoodsCategories;
import seedu.address.model.goods.GoodsName;
import seedu.address.model.person.Name;

public class SupplierNamePredicateTest {
    private static final String DATETIME_PROCUREMENT_VALID = "2024-10-10 12:00";
    private static final String DATETIME_ARRIVAL_VALID = "2024-12-12 12:00";
    private final Goods testGoods = new Goods(new GoodsName("Gardenia Bread"), GoodsCategories.CONSUMABLES);

    @Test
    public void gooodsNamePredicateTest_success() {
        GoodsReceipt testReceipt = new GoodsReceipt(testGoods, new Name("Alex Yeoh"),
                new Date(DATETIME_PROCUREMENT_VALID), new Date(DATETIME_ARRIVAL_VALID), false, 1, 1.0);

        SupplierNamePredicate testPredicate = new SupplierNamePredicate(new Name("Alex Yeoh"));
        boolean posResult = testPredicate.test(testReceipt);
        assertTrue(posResult);

        SupplierNamePredicate testPredicate2 = new SupplierNamePredicate(new Name("Test User"));
        boolean negResult = testPredicate2.test(testReceipt);
        assertFalse(negResult);
    }
}
