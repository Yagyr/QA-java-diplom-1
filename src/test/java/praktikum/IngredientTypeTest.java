package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTypeTest() {
        Assert.assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTypeTest() {
        Assert.assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
