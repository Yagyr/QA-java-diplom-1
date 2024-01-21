package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient, ingredient1, ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1,2);

        Assert.assertEquals(ingredient1, burger.ingredients.get(2));
        Assert.assertEquals(ingredient2, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(ingredient1.getPrice()).thenReturn(2f);

        float expectedPrice = 13f;

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("White bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        String expectedReceipt = "(==== White bun ====)\n= sauce ingredient =\n(==== White bun ====)\n\nPrice: 11.000000\n";
        String actualReceipt = burger.getReceipt();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
