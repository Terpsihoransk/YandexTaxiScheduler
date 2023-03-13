package ru.example.yandextaxischeduler.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.example.yandextaxischeduler.model.Coordinate;
import ru.example.yandextaxischeduler.properties.CoordinateProperties;
import ru.example.yandextaxischeduler.service.TaxiService;

@Service
@RequiredArgsConstructor
public class YandexScheduler {

    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {

        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());
        taxiService.getPrice(startPoint, endPoint);

    }
}
