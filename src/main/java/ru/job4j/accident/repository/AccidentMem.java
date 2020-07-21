package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private static final AccidentMem INST = new AccidentMem();

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private final AtomicInteger idx = new AtomicInteger(6);

    private AccidentMem() {
        accidents.put(1, new Accident(1, "проезд на красный свет", "description 1", "Москва, Мухасранский переулок, д.8"));
        accidents.put(2, new Accident(2, "пересечение сплошной", "description 2", "Москва, Херсонская улица, д.15"));
        accidents.put(3, new Accident(3, "остановка в неположенном месте", "description 3", "Москва, Редько Педровский проезд, д.69А"));
        accidents.put(4, new Accident(4, "нарушение правил разметки", "description 4", "Москва, Красно-Богатырская ул. д. 1с7"));
        accidents.put(5, new Accident(5, "пересечение стоп-линии на красный сигнал светофора", "description 5", "Москва, Сявкина ул. д. 36/8"));
    }

    public Map<Integer, Accident> getAccidents() {
        return accidents;
    }

    public static AccidentMem instOf() {
        return INST;
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accident.setId(idx.getAndIncrement());
        accidents.put(accident.getId(), accident);
    }
}
