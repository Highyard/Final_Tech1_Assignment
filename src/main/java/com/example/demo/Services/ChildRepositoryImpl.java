package com.example.demo.Services;

import com.example.demo.domain.Child;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChildRepositoryImpl implements ChildRepository {

    private ArrayList<Child> children = new ArrayList<>();

    @Override
    public ArrayList<Child> readAllChildren() {
        return children;
    }


    public boolean addChild(Child child) {
        return children.add(child);
    }
}
