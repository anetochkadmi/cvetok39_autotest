import org.cvetok39.calculator.core.CalculatorColor;
import org.cvetok39.calculator.core.CalculatorPack;
import org.cvetok39.calculator.core.CalculatorParams;
import org.cvetok39.calculator.tests.CalculatorAddFlowerAndCompareInCartTest;

public class CalculatorTestCases {
    public static void testWithParams(
            String flower,
            int height,
            int bouquetsCount,
            int flowersCount,
            CalculatorPack pack,
            CalculatorColor color
    ) {
        CalculatorParams params = new CalculatorParams();

        params.setFlower(flower);
        params.setHeight(height);
        params.setBouquetsCount(bouquetsCount);
        params.setPack(pack);
        params.setColor(color);
        params.setFlowersCount(flowersCount);

        CalculatorAddFlowerAndCompareInCartTest calculatorTest
                = new CalculatorAddFlowerAndCompareInCartTest(params);
        calculatorTest.run();
    }

    public static void main(String[] args) {
        testWithParams(
                "Роза",
                50,
                2,
                12,
                CalculatorPack.FILM,
                CalculatorColor.RED
        );

        testWithParams(
                "Роза",
                50,
                20,
                12,
                CalculatorPack.FILM,
                CalculatorColor.RED
        );

        testWithParams(
                "Роза",
                50,
                2,
                12,
                CalculatorPack.FILM,
                CalculatorColor.RED
        );
    }
}
