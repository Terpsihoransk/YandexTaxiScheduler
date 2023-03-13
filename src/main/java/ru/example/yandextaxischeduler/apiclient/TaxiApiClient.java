package ru.example.yandextaxischeduler.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.yandextaxischeduler.model.Price;

@FeignClient(name = "yandexclient", url = "${yandex.url}")
public interface TaxiApiClient {

    @GetMapping
    Price getPrice(@RequestParam String clid, @RequestParam String apiKey, @RequestParam String rll);
}
