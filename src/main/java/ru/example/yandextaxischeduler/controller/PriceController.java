package ru.example.yandextaxischeduler.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.yandextaxischeduler.model.MomentPrice;
import ru.example.yandextaxischeduler.service.TaxiService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final TaxiService taxiService;

    @GetMapping("/prices")
    public List<MomentPrice> getAllPrice() {
        return taxiService.getAllPrice();
    }

}
