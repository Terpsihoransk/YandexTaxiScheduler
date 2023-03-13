package ru.example.yandextaxischeduler.repository;

import org.springframework.data.repository.CrudRepository;
import ru.example.yandextaxischeduler.model.MomentPrice;

import java.util.List;

public interface PriceRepository extends CrudRepository<MomentPrice, Long> {

    List<MomentPrice> findAll();
}
