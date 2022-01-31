package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Calina", 1, "Alpha"));
        cars.add(new Car("Tesla", 555, "Beta"));
        cars.add(new Car("Priora", 32, "}{opa"));
        cars.add(new Car("Niva", 666, "Ad"));
        cars.add(new Car("Ferrari", 2, "Cool"));
        cars.add(new Car("XZ", 0, "Zero"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count > 5) {
            count = 5;
        }
        return cars.subList(0, count);
    }
}
