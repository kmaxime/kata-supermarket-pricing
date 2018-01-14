package kata.market.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class PackagePricing extends Pricing {
    public float calculatePrice(Item item, float numberBought)
    {
        int numberForReduction = (int) item.getReductionList().keySet().iterator().next() ;
        int timesReductionApplied = (int)(numberBought /numberForReduction) ;
        float numberOfFullPriceGoods = numberBought % numberForReduction;
        float reductionValue = (float)item.getReductionList().get(numberForReduction);
        float reducedPrice = timesReductionApplied*item.getUnitaryPrice()*numberForReduction*reductionValue;
        float unreducedPrice = numberOfFullPriceGoods*item.getUnitaryPrice();
        return reducedPrice+unreducedPrice;
    }
}
