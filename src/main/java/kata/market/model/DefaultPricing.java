package kata.market.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultPricing extends Pricing {
    public float calculatePrice(Item item, float numberBought) {
        return (item.getUnitaryPrice() * numberBought);
    }
}
