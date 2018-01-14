package kata.market.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PackagePricingTest {

    PackagePricing aPackagePricing;
    @Test
    @Parameters({"2f, 100f",
                "3f, 135f",
                "4f, 185f",
                "6f, 270f"})
    public void should_apply_reduction_when_package_number_needed_reached(float inputNumberToBuy, float expectedPrice)
    {
        //given
        LinkedHashMap inputLinkedHashMap = new LinkedHashMap<Integer, Float>();
        inputLinkedHashMap.put(3, 0.9f);
        Item anItem = new Item (true , true, inputLinkedHashMap, "item", 50);
        aPackagePricing = new PackagePricing();

        //when
        aPackagePricing.calculatePrice(anItem, inputNumberToBuy);

        //then
        assertThat(aPackagePricing.calculatePrice(anItem, inputNumberToBuy),is(expectedPrice));
    }
}
