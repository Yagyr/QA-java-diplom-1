package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData(){
        return new Object[][]{
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sweet sauce", 200.5f},
                {FILLING,"carrot", 300},
                {FILLING,"sausage", 30000.001f}
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String expectedName = name;
        String actualName = ingredient.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = type;
        IngredientType actualType = ingredient.getType();

        Assert.assertEquals(expectedType, actualType);
    }
}
