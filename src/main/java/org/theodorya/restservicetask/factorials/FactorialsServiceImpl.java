package org.theodorya.restservicetask.factorials;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FactorialsServiceImpl implements FactorialsService {
    @Override
    public List<BigInteger> getFactorialsFrom1ToN(Integer n) {
            BigInteger a = BigInteger.valueOf(1);
            if(n == 0) return List.of(a);

            List<BigInteger> output = new ArrayList<>(n);
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= i; j++) {
                    a = a.multiply(BigInteger.valueOf(j));
                }
                output.add(a);
                a = BigInteger.valueOf(1);
            }

            return output;
    }
}
