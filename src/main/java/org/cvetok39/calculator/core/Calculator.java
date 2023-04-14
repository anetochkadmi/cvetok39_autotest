package org.cvetok39.calculator.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Calculator {
    ChromeDriver driver;

    private int storedPrice = 0;

    public Calculator(ChromeDriver _driver) {
        driver = _driver;
    }

    /* TODO: selectFlower */

    public void selectColor(String color) throws Exception {
        boolean isSelected = false;

        WebElement colorSelector = driver.findElement(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_color > div > button"));
        colorSelector.click();

        List<WebElement> colorElements = driver.findElements(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_color .flower-params__dropdown-list .flower-params__dropdown-item"));

        for (WebElement colorElement : colorElements) {
            if (Objects.equals(colorElement.getAttribute("textContent").trim().toLowerCase(), color.toLowerCase())) {
                colorElement.click();
                isSelected = true;
                break;
            }
        }

        if (!isSelected) {
            throw new Exception("Выбранный цвет недоступен");
        }

        System.out.println("Для калькулятора выбран цвет: " + color);
    }

    public void selectHeight(String height) throws Exception {
        boolean isSelected = false;

        WebElement heightSelector = driver.findElement(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_size > div > button"));
        heightSelector.click();

        List<WebElement> heightElements = driver.findElements(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_size .flower-params__dropdown-list .flower-params__dropdown-item"));

        for (WebElement heightElement : heightElements) {
            if (Objects.equals(heightElement.getAttribute("textContent").trim().toLowerCase(), height.toLowerCase())) {
                heightElement.click();
                isSelected = true;
                break;
            }
        }

        if (!isSelected) {
            throw new Exception("Выбранная высота недоступен");
        }

        System.out.println("Для калькулятора выбрана высота: " + height);
    }

    public void selectFlowersCount(int count) throws Exception {
        WebElement maxElement = driver.findElement(By.xpath("/html/body/main/div/section/div[1]/div[3]/div[1]/ul/li[3]/div[1]/div/div/div/div/div/div[2]"));

        int minCount = 10;
        int maxCount = Integer.parseInt(maxElement.getAttribute("textContent"));

        if (!(count > minCount && count < maxCount)) {
            throw new Exception("Данное кол-во цветов {" + count + "} недоступно");
        }

        String inputCssSelector = "li.flower-params__item.flower-params__item_range > div.flower-params__item-inner.flower-params__item-inner_range.active > div > div > label > input";
        WebElement input = driver.findElement(By.cssSelector(inputCssSelector));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = " + "'" + count + "';" + "arguments[0].dispatchEvent(new Event('input'));", input);
    }

    public void selectPack(String pack) throws Exception {
        boolean isSelected = false;

        WebElement packSelector = driver.findElement(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_pack > div > button"));
        packSelector.click();

        List<WebElement> packElements = driver.findElements(By.cssSelector(".flowers-constructor__controls .flowers-constructor__params .flower-params__item.flower-params__item_pack .flower-params__dropdown-list .flower-params__dropdown-item"));

        for (WebElement packElement : packElements) {
            if (Objects.equals(packElement.getAttribute("textContent").trim().toLowerCase(), pack.toLowerCase())) {
                packElement.click();
                isSelected = true;
                break;
            }
        }

        if (!isSelected) {
            throw new Exception("Выбранная упаковка недоступен");
        }

        System.out.println("Для калькулятора выбрана упаковка: " + pack);
    }

    public void selectBouquetsCount(String count) throws Exception {
        boolean isSelected = false;

        WebElement countSelector = driver.findElement(By.xpath("/html/body/main/div/section/div[1]/div[3]/div[1]/ul/li[5]/div/button"));
        countSelector.click();

        List<WebElement> countElements = driver.findElements(By.xpath("/html/body/main/div/section/div[1]/div[3]/div[1]/ul/li[5]/div/div/div[2]/ul/li"));

        for (WebElement countElement : countElements) {
            String elementCount = countElement.getAttribute("textContent");

            if (Integer.parseInt(elementCount.replaceAll("[^0-9]", "")) == Integer.parseInt(count.replaceAll("[^0-9]", ""))) {
                countElement.click();
                isSelected = true;
                break;
            }
        }

        if (!isSelected) {
            throw new Exception("Выбранное кол-во букетов недоступно");
        }

        System.out.println("Для калькулятора выбранно кол-во букетов: " + count);
    }

    public void storePrice() {
        WebElement priceParagraph = driver.findElement(By.cssSelector("li.flower-params__item_range p.range__price"));
        storedPrice = Integer.parseInt(priceParagraph.getText().replaceAll("[^0-9]", ""));
    }

    public void addFlowerToCart() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.flowers-constructor__submit button")));

        WebElement submitButton = driver.findElement(By.cssSelector("div.flowers-constructor__submit button"));
        submitButton.click();
    }

    public int getStoredPrice() {
        return storedPrice;
    }
}
