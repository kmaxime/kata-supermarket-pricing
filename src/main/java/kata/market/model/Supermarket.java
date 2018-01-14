package kata.market.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.LinkedHashMap;

import java.util.Iterator;
import java.util.Map;

@Data
@AllArgsConstructor
public class Supermarket {
    public float calculateBill(Customer customer)
    {

        float bill = 0f;
        Iterator it = customer.getCart().entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry currentItem = (Map.Entry)it.next();
            Item itemToCalculate =  (Item)currentItem.getKey();
            float numberBought = (Float) currentItem.getValue();

            if(itemToCalculate.isHasReduction())
            {
                bill += new PackagePricing().calculatePrice(itemToCalculate, numberBought);
            }
            else if ((!itemToCalculate.isByWeight()) && (numberBought - (int)numberBought != 0))
            {
                //Error case : you cannot buy half an item !
            }
            else
            {
                bill += new DefaultPricing().calculatePrice(itemToCalculate, numberBought);
            }
        }
        return bill;
    }

    public void addReduction (Item item, int numberToBuy, float reduction)
    {
        removeReductions(item);
        item.setHasReduction(true);
        item.setReductionList(new LinkedHashMap<Integer, Float>());
        item.getReductionList().put(numberToBuy, reduction);
    }
    public void removeReductions (Item item)
    {
        if(item.isHasReduction())
        {
            item.setHasReduction(false);
            item.setReductionList(new LinkedHashMap<Integer, Float>());
        }

    }
}
