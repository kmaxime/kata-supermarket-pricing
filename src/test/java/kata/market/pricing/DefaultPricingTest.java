package kata.market.pricing;

import kata.market.model.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultPricingTest {

    private DefaultPricing aDefaultPricing;

    @Test
    public void should_calculate_price() {
        //given
        Item anItem = new Item(true, null, "potato", 5);
        aDefaultPricing = new DefaultPricing();
        int valueToBuy = 2;

        //when
        aDefaultPricing.calculatePrice(anItem, valueToBuy);

        //then
        assertThat(aDefaultPricing.calculatePrice(anItem, valueToBuy), is(10f));
    }
}
