package kata.market.model;

import lombok.Data;

@Data
public abstract class Pricing {

    public abstract float calculatePrice(Item item, float numberBought);

}
