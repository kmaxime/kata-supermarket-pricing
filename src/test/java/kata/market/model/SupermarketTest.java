package kata.market.model;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupermarketTest {

    private Supermarket aSupermarket;
    private Customer aCustomer;


    @Test
    public void item_should_correctly_be_updated_when_reduction_set() {
        //given
        aSupermarket = new Supermarket();
        Item anItem = new Item(false, null, "sweep", 50);

        //when
        aSupermarket.addReduction(anItem, 2, 0.5f);

        //then
        assertThat(anItem.getReductionValueByNumber()._1(), is(2));
        assertThat(anItem.getReductionValueByNumber()._2(), is(0.5f));
    }

    @Test
    public void item_reduction_should_correctly_be_replaced_when_new_reduction_set() {
        //given
        aSupermarket = new Supermarket();
        Item anItem = new Item(false, null, "sweep", 50);
        aSupermarket.addReduction(anItem, 10, 0.9f);

        //when
        aSupermarket.addReduction(anItem, 2, 0.5f);

        //then
        assertThat(anItem.getReductionValueByNumber()._1(), is(2));
        assertThat(anItem.getReductionValueByNumber()._2(), is(0.5f));
    }


    @Test
    public void item_should_correctly_be_updated_when_reduction_removed() {
        //given
        aSupermarket = new Supermarket();
        Tuple2<Integer, Float> inputReduction = Tuple.of(2, 0.5f);
        Item anItem = new Item(false, inputReduction, "sweep", 50);

        //when
        aSupermarket.removeReductions(anItem);

        //then
        assertThat(anItem.getReductionValueByNumber()._1(), is(nullValue()));
    }

    @Test
    public void price_should_be_correct_when_calculating_bill() {
        //given
        aSupermarket = new Supermarket();
        aCustomer = new Customer();
        Item aSweep = new Item(false, null, "sweep", 50);
        Item aPotato = new Item(true, null, "potato", 5);
        Item aSoap = new Item(false, null, "soap", 10);
        aCustomer.addToCart(aSweep, 4);
        aCustomer.addToCart(aPotato, 2.2f);
        aCustomer.addToCart(aSoap, 3);
        aSupermarket.addReduction(aSoap, 2, 0.5f);

        //when
        aSupermarket.calculateBill(aCustomer);
        //then
        assertThat(aSupermarket.calculateBill(aCustomer), is(231.0f));
    }

}