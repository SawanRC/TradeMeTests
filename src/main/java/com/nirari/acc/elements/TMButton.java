package com.nirari.acc.elements;

import com.nirari.acc.factory.ConcreteImplementation;

@ConcreteImplementation(ImplementedBy = TMButtonImpl.class)
public interface TMButton extends TMElement {

    @Override
    void click();
}
