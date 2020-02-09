package com.example.Hospital.service;

import com.example.Hospital.TestController_2;
import com.example.Hospital.model.SkierowanieDoLekarza;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SkierowanieMapService implements SkierowanieServis {

    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private Map<Integer, SkierowanieDoLekarza> skierowania = new HashMap<>();


    @Override
    public List<SkierowanieDoLekarza> listSkierowanie() {
        return null;
    }

    @Override
    public SkierowanieDoLekarza getSkierowanie(Integer id) throws Exception {
        SkierowanieDoLekarza skierowanieDoLekarza = skierowania.get(id);
        if(skierowanieDoLekarza == null){
            //throw new TestController_2().NotFoundException();
        }
        return skierowanieDoLekarza;
    }

    @Override
    public void deleteSkierowanie(Integer id) {
        skierowania.remove(id);
    }

    @Override
    public SkierowanieDoLekarza createSkierowanie(SkierowanieDoLekarza skierowanie) {

        skierowanie.setId(new Random().nextInt());
        skierowania.put(skierowanie.getId(),skierowanie);
        return null;
    }

    @Override
    public SkierowanieDoLekarza updateSkierowanie(SkierowanieDoLekarza skierowanie) throws Exception {
        SkierowanieDoLekarza existing = getSkierowanie(skierowanie.getId());
        existing.setLekarz(skierowanie.getLekarz());
        existing.setPacjent(skierowanie.getPacjent());
        existing.setTermin(skierowanie.getTermin());;
        skierowania.put(existing.getId(),existing);

        return existing;
    }
}
