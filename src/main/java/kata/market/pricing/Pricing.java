package kata.market.pricing;

import kata.market.model.Item;
import lombok.Data;

@Data
public abstract class Pricing {

    public abstract float calculatePrice(Item item, float numberBought);

}
