package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void topKFrequentTest() {
        Solution solution = new Solution();
        List<String> result = Arrays.asList("i", "love");
        Assert.assertEquals(result, solution.topKFrequent(
                new String[]{"i","love","leetcode","i","love","coding"}, 2));
        result = Arrays.asList("the","is","sunny","day");
        Assert.assertEquals(result, solution.topKFrequent(new
                String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }

}