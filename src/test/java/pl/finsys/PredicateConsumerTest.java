package pl.finsys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pl.finsys.domain.Invoice;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.fest.assertions.Assertions.assertThat;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:27
 */
public class PredicateConsumerTest {
    protected Logger logger = LoggerFactory.getLogger(PredicateConsumerTest.class);


    private Invoice updateDiscount(Invoice invoice, Predicate<Invoice> predicate, Consumer<Invoice> consumer) {

        //Use the predicate to decide when to update the discount.
        if (predicate.test(invoice)) {
            //Use the consumer to update the discount value.
            consumer.accept(invoice);
        }
        return invoice;
    }

    @Test
    public void shouldDiscount() {
        Invoice invoice1 = new Invoice("Jarek K.", 2000);
        updateDiscount(invoice1, invoice -> invoice.getAmount() > 1000, invoice -> invoice.setDiscount(10));
        assertThat(invoice1.getDiscount()).isEqualTo(10);
    }

    @Test
    public void shouldNotDiscount() {
        Invoice invoice1 = new Invoice("Jarek K.", 500);
        updateDiscount(invoice1, invoice -> invoice.getAmount() > 1000, invoice -> invoice.setDiscount(10));
        assertThat(invoice1.getDiscount()).isZero();
    }
}
