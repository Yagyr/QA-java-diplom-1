package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("checkName", 10.5f);

    @Test
    public void checkGetName() {
        String actualName = bun.getName();
        String expectedName = "checkName";

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetPrice() {
        float actualPrice = bun.getPrice();
        float expectedPrice = 10.5f;

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
