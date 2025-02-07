package br.com.estudos.unit_testing.business;

import br.com.estudos.unit_testing.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
    }
}
