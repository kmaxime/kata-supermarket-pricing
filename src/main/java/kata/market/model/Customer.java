package kata.market.model;
import java.util.LinkedHashMap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private Supermarket supermarket;
    private LinkedHashMap cart = new LinkedHashMap<Item, Float>();
    public void addToCart(Item item, float number)
    {
        if(cart.containsKey(item))
        {
            cart.put(item, number+ (Float) cart.get(item));
        }
        else
        {
            cart.put(item, number);
        }
    }
    public void removeFromCart(Item item, float number)
    {
        if(cart.containsKey(item))
        {
            float numberInitial =(Float)cart.get(item);
            float result = numberInitial - number;
            if( result > 0)
            {
                cart.replace(item, (Float) cart.get(item)-number);
            }
            else //As it is not mentioned in the kata subject, no exception is processed for removing more than the actual number of goods in the cart
            {
                cart.remove(item);
            }
        }
    }

}

