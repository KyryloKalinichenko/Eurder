package com.example.eurder.domain.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemGroupTest {

    @Test
    void getTotalPriceOfItemGroup_WhenAmountPositive_thenReturnRightPrice() {
        ItemGroup itemGroup = new ItemGroup(new Item("lol", "lollol", 2.1, 2), 2);

        Assertions.assertEquals(4.2, itemGroup.getTotalPrice());
    }

    @Test
    void getTotalPriceOfItemGroup_WhenAmountNegative_thenThrow() {


        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemGroup(new Item("lol", "lollol", 2.1, 2), -1)
                );
    }
}