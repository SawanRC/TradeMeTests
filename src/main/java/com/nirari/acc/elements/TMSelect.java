package com.nirari.acc.elements;

import com.nirari.acc.factory.ConcreteImplementation;

import java.util.List;

@ConcreteImplementation(ImplementedBy = TMSelectImpl.class)
public interface TMSelect extends TMElement {

    List<String> getAvailableItems();
}
