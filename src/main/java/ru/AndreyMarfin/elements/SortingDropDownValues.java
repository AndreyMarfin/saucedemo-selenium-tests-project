package ru.AndreyMarfin.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropDownValues {
    NAME_AZ(By.cssSelector("[data-test=product_sort_container] > [value=az]"), "Name (A to Z)"),
    NAME_ZA(By.cssSelector("[data-test=product_sort_container] > [value=za]"), "Name (Z to A)"),
    PRICE_LH(By.cssSelector("[data-test=product_sort_container] > [value=lohi]"), "Price (low to high)"),
    PRICE_HL(By.cssSelector("[data-test=product_sort_container] > [value=hilo]"), "Price (high to low)");

    @Getter
    By elementlocator;
    @Getter
    String title;

    SortingDropDownValues(By cssSelector, String title) {
        this.elementlocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }
}
