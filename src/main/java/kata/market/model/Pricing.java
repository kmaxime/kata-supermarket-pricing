package kata.market.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pricing {

    private Item item;

public abstract float calculatePrice(Item item, float numberBought);

}
