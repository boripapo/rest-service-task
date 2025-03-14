package org.theodorya.restservicetask.factorials;

import java.math.BigInteger;
import java.util.List;

public class FactorialsResponse {
    private List<BigInteger> factorials;

    public FactorialsResponse(List<BigInteger> factorials) {
        this.factorials = factorials;
    }

    public List<BigInteger> getFactorials() {
        return factorials;
    }

    public void setFactorials(List<BigInteger> factorials) {
        this.factorials = factorials;
    }
}
