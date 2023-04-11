package org.cvetok39.cart.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Objects;

public class Cart {
    ChromeDriver driver;

    public Cart(ChromeDriver _driver) {
        driver = _driver;
    }

    public void compareItemByParams(
            WebElement $basketElement,

            int price,

            String color,
            String height,
            int flowersCount,
            String bouquetsCount) {
        WebElement $basketElementTitle = $basketElement.findElement(By.cssSelector("button.order-structure__product-title"));
        int basketElementFlowersCount = Integer.parseInt($basketElementTitle.getText().replaceAll("[^0-9]", ""));

        if (basketElementFlowersCount != flowersCount) {
            throw new Error("Кол-во цветков элемента в корзине не соответствует заданным параметрам");
        }

        List<WebElement> $basketElementParams = $basketElement.findElements(By.cssSelector("dl.order-structure__product-params div.order-structure__params-group"));
        for (WebElement $param : $basketElementParams) {
            int bouquetsCountAsInt = Integer.parseInt(bouquetsCount.replaceAll("[^0-9]", ""));

            WebElement $title = $param.findElement(By.cssSelector(".order-structure__params-title"));
            WebElement $value = $param.findElement(By.cssSelector(".order-structure__params-value"));
            String value = $value.getText().toLowerCase();


            switch ($title.getText()) {
                case "Высота" -> {
                    if (!Objects.equals(value, height.toLowerCase())) {
                        throw new Error("Высота элемента в корзине не соответствует заданным параметрам");
                    }

                    break;
                }

                case "Цвет" -> {
                    if (!Objects.equals(value, color.toLowerCase())) {
                        throw new Error("Цвет элемента в корзине не соответствует заданным параметрам");
                    }

                    break;
                }

                case "Количество" -> {
                    int itemBouquetsCount = Integer.parseInt(value.replaceAll("[^0-9]", ""));

                    if (itemBouquetsCount != bouquetsCountAsInt) {
                        throw new Error("Кол-во букетов элемента в корзине не соответствует заданным параметрам");
                    }

                    break;
                }

                case "Стоимость" -> {
                    WebElement $discountField = null;

                    try {
                        $discountField = $param.findElement(By.cssSelector(".discount-price"));
                    } catch (Exception e) { /* ignore */ }

                    int deliveryPrice = bouquetsCountAsInt > 1 ? (bouquetsCountAsInt - 1) * 90 : 0;
                    int finalPrice = price - deliveryPrice;

                    int priceFromElement = Integer.parseInt(
                            ($discountField != null ? $discountField.getText().toLowerCase() : value).replaceAll("[^0-9]", "")
                    );

                    if (finalPrice != priceFromElement) {
                        throw new Error("Цена элемента в корзине не соответствует заданным параметрам");
                    }

                    break;
                }
            }
        }
    }

    public void compareWithFirstBasketItem(
            int price,

            String color,
            String height,
            int flowersCount,
            String bouquetsCount
    ) {
        WebElement $firstBasketElement = driver.findElement(By.cssSelector("div.order-structure__swiper.js-order-structure-swiper > ul > li"));
        compareItemByParams(
                $firstBasketElement,

                price,
                color,
                height,
                flowersCount,
                bouquetsCount
        );
    }
}
