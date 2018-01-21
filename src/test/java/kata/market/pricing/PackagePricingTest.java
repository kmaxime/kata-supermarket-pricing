package kata.market.pricing;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.market.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PackagePricingTest {

    private PackagePricing aPackagePricing;

    @Test
    @Parameters({"2f, 100f",
            "3f, 135f",
            "4f, 185f",
            "6f, 270f"})
    public void should_apply_reduction_when_package_number_needed_reached(float inputNumberToBuy, float expectedPrice) {
        //given
        Tuple2<Integer, Float> inputReduction = Tuple.of(3, 0.9f);
        Item anItem = new Item(true, inputReduction, "item", 50);
        aPackagePricing = new PackagePricing();

        //when
        aPackagePricing.calculatePrice(anItem, inputNumberToBuy);

        //then
        assertThat(aPackagePricing.calculatePrice(anItem, inputNumberToBuy), is(expectedPrice));
    }
}
