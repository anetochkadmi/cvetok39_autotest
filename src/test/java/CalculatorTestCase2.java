import org.cvetok39.calculator.core.CalculatorColor;
import org.cvetok39.calculator.core.CalculatorPack;
import org.cvetok39.calculator.core.CalculatorParams;
import org.cvetok39.calculator.tests.CalculatorAddFlowerAndCompareInCartTest;

public class CalculatorTestCase2 {
    public static void main(String[] args) {
        CalculatorParams params = new CalculatorParams();

        params.setFlower("Роза");
        params.setHeight(50);
        params.setBouquetsCount(1);
        params.setPack(CalculatorPack.FILM);
        params.setColor(CalculatorColor.RED);
        params.setFlowersCount(11);

        CalculatorAddFlowerAndCompareInCartTest calculatorTest = new CalculatorAddFlowerAndCompareInCartTest(params);
        calculatorTest.run();
    }
}