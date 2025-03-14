package org.theodorya.restservicetask.factorials;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class FactorialsController {
    private final FactorialsServiceImpl factorialsService;

    @Autowired
    public FactorialsController(FactorialsServiceImpl factorialsService) {
        this.factorialsService = factorialsService;
    }

    @GetMapping("/factorials")
    public FactorialsResponse getFactorials(@RequestParam
                                                @NotNull(message = "Parameter must exist.")
                                                @Min(value = 0, message = "Number must not be lower than 0.")
                                                @Max(value = 1000, message = "Number must not be higher than 1000.")
                                                Integer n) {
        return new FactorialsResponse(factorialsService.getFactorialsFrom1ToN(n));
    }
}
