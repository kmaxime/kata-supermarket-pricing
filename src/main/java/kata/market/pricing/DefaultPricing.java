package kata.market.pricing;

import kata.market.model.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultPricing extends Pricing {
    public float calculatePrice(Item item, float numberBought) {
        return (item.getUnitaryPrice() * numberBought);
    }
}
