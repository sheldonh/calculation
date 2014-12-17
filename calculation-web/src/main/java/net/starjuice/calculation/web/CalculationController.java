package net.starjuice.calculation.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @RequestMapping("/sum")
    public @ResponseBody String sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(a + b);
    }

    @RequestMapping("/difference")
    public @ResponseBody String difference(@RequestParam("minuend") int minuend, @RequestParam("subtrahend") int subtrahend) {
        return String.valueOf(minuend - subtrahend);
    }
}
