package com.example.Hospital.service;

import com.example.Hospital.model.SkierowanieDoLekarza;

import java.util.List;

public interface SkierowanieServis {
    List<SkierowanieDoLekarza> listSkierowanie();
    SkierowanieDoLekarza getSkierowanie(Integer id) throws Exception;
    void deleteSkierowanie(Integer id);
    SkierowanieDoLekarza createSkierowanie(SkierowanieDoLekarza skierowanie);
    SkierowanieDoLekarza updateSkierowanie (SkierowanieDoLekarza skierowanie) throws Exception;
}
