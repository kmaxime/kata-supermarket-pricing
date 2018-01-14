package kata.market.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
public class Item {
    private boolean byWeight;
    private boolean hasReduction;
    private LinkedHashMap reductionList = new LinkedHashMap<Integer, Float>();
    private String name;
    private int unitaryPrice;
}
