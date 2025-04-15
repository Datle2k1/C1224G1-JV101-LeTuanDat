package org.example.casestudymodule3.service;

import org.example.casestudymodule3.model.Skin;

import java.util.List;

public interface ICustomerDao {
    List<Skin> getAllSkin();
    void addToCart(int orderId, int skinId);
}
