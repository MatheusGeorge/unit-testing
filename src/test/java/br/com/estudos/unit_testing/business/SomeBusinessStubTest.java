package br.com.estudos.unit_testing.business;

import br.com.estudos.unit_testing.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class SomeBusinessStubTest {

    class SomeDataServiceStub implements SomeDataService {

        @Override
        public int[] retrieveAllData() {
            return new int[] {1,2,3};
        }
    }

    class SomeDataServiceEmptyStub implements SomeDataService {

        @Override
        public int[] retrieveAllData() {
            return new int[] {};
        }
    }

    class SomeDataServiceOneElementStub implements SomeDataService {

        @Override
        public int[] retrieveAllData() {
            return new int[] {5};
        }
    }

    @Test
    public void calculateSumUsingDataServiceBasic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumEmpty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumOneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
