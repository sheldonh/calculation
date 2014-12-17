package net.starjuice.calculation.web.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTester;
import net.starjuice.calculation.web.CalculationController;
import org.junit.Assert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@AcceptanceTestComponent
public class ImperativeWebTester implements ImperativeTester {

    private MockMvc mockMvc;
    private int actual;

    @Override
    public void make_a_calculator() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CalculationController()).build();
    }

    @Override
    public void make_calculator_add_two_numbers(int a, int b) {
        RequestBuilder request = MockMvcRequestBuilders.get("/sum").
                param("a", String.valueOf(a)).
                param("b", String.valueOf(b));
        actual = Integer.parseInt(performWebRequest(request));
    }

    @Override
    public void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend) {
        RequestBuilder request = MockMvcRequestBuilders.get("/difference").
                param("minuend", String.valueOf(minuend)).
                param("subtrahend", String.valueOf(subtrahend));
        actual = Integer.parseInt(performWebRequest(request));
    }

    private String performWebRequest(RequestBuilder requestBuilder) {
        try {
            return mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void check_calculated_value(int expected) {
        Assert.assertEquals(expected, actual);
    }
}
