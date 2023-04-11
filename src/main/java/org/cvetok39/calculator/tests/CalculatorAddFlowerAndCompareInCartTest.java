package org.cvetok39.calculator.tests;

import org.cvetok39.BaseTest;

import org.cvetok39.calculator.core.Calculator;
import org.cvetok39.calculator.core.CalculatorParams;
import org.cvetok39.cart.core.Cart;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorAddFlowerAndCompareInCartTest extends BaseTest {
    public final CalculatorParams calculatorParams;
    public final Calculator calculator;
    public final Cart cart;

    public CalculatorAddFlowerAndCompareInCartTest(CalculatorParams _calculatorParams) {
        calculatorParams = _calculatorParams;

        ChromeDriver driver = getDriver();

        calculator = new Calculator(driver);
        cart = new Cart(driver);
    }

    public void run() {
        ChromeDriver driver = getDriver();

        try {
            System.out.println("\nСтарт теста [CalculatorAddFlowerAndCompareInCartTest]");

            openPageWithCalculator();
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("document.querySelector('.app-banner')?.remove();");

            calculator.selectColor(calculatorParams.getColor());
            Thread.sleep(500);

            calculator.selectHeight(calculatorParams.getHeight());
            Thread.sleep(1000);

            calculator.selectFlowersCount(calculatorParams.getFlowersCount());
            Thread.sleep(500);

            calculator.selectPack(calculatorParams.getPack());
            Thread.sleep(500);

            calculator.selectBouquetsCount(calculatorParams.getBouquetsCount());
            Thread.sleep(500);

            calculator.storePrice();
            Thread.sleep(5000);

            calculator.addFlowerToCart();
            Thread.sleep(5000);


            cart.compareWithFirstBasketItem(
                    calculator.getStoredPrice(),

                    calculatorParams.getColor(),
                    calculatorParams.getHeight(),
                    calculatorParams.getFlowersCount(),
                    calculatorParams.getBouquetsCount()
            );
            //Thread.sleep(5000);

            System.out.println("Тест [CalculatorAddFlowerAndCompareInCartTest] завершен успешно!\n");
        } catch (Exception e) {
            System.out.println("Тест [CalculatorAddFlowerAndCompareInCartTest] провален");
            System.out.println("[CalculatorAddFlowerAndCompareInCartTest]: Error " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    void openPageWithCalculator() {
        ChromeDriver driver = getDriver();
        driver.get("https://cvetok39.ru");
    }
}