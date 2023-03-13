package ru.example.yandextaxischeduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.yandextaxischeduler.apiclient.TaxiApiClient;
import ru.example.yandextaxischeduler.model.Coordinate;
import ru.example.yandextaxischeduler.model.MomentPrice;
import ru.example.yandextaxischeduler.model.Price;
import ru.example.yandextaxischeduler.properties.YandexProperties;
import ru.example.yandextaxischeduler.repository.PriceRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxiService {

    private final YandexProperties yandexProperties;
    private final TaxiApiClient taxiApiClient;
    private final PriceRepository priceRepository;

    public void getPrice(Coordinate startPoint, Coordinate endPoint) {

        String rll = startPoint.toString() + "~" + endPoint.toString();
        String clid = yandexProperties.getClid();
        String apiKey = yandexProperties.getApiKey();

        Price currentPrice = taxiApiClient.getPrice(clid, apiKey, rll);
        if(currentPrice.getOptions().isEmpty()) {
            throw new RuntimeException("Options are empty");
        }

        double priceDouble = currentPrice.getOptions().get(0).getPrice();
        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Asia/Novosibirsk")),
                priceDouble
        );
        priceRepository.save(momentPrice);

    }

    public List<MomentPrice> getAllPrice() {

        return priceRepository.findAll();

    }
}
