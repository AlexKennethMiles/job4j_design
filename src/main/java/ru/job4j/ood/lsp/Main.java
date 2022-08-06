package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * В первом примере нарушен принцип LSP — поведение класса-потомка изменяет поведение класса-родителя.
         * Ожидая получить площадь 5*4=20,мы получили 5*5=25.
         * Метод {@link ru.job4j.ood.lsp.Square#setHeight(int)} хоть и переопределён,
         * но значение поля {@link ru.job4j.ood.lsp.Square#height} не используется для расчёта площади.
         */
        Rectangle rectangle = new Square(5, 5);
        rectangle.setHeight(4);
        System.out.println(rectangle.getArea());

        /**
         * В следующем примере LSP не соблюдается из-за изменения предусловия.
         * В переопределённом методе {@link ru.job4j.ood.lsp.WaterSupplyWithAProblem#pumpWater(float)}
         * убрана проверка статуса клиента. Поведение класса-потомка изменило поведение класса-родителя,
         * потому через {@link ru.job4j.ood.lsp.WaterSupply} теперь можно перекачать воду невалидному клиенту.
         */
        Client client = new Client("Test", false, 0);
        System.out.println(client.getWaterMeter());
        WaterSupply waterSupply = new WaterSupplyWithAProblem(client);
        waterSupply.pumpWater(200);
        System.out.println(client.getWaterMeter());

        /**
         * В следующем примере LSP не соблюдается из-за изменения постусловия.
         * В переопределённом методе {@link ru.job4j.ood.lsp.SmartAuto#refuel(String, float)}
         * добавлено условие, что заданная заправка производится только начиная со значения запаса топлива в 100 у.е.
         * Поведение класса-потомка изменило поведение класса-родителя, и теперь нельзя заправить экземпляр класса
         * {@link ru.job4j.ood.lsp.Auto} через его класс-потомок, потому что в последнем есть на это наложено условие.
         * Вместо 5000 у.е. в авто будет заправлено только 100 у.е.
         */
        Auto auto = new SmartAuto("Electric", 0);
        System.out.println(auto.getFuelReserve());
        auto.refuel("Electric", 5000);
        System.out.println(auto.getFuelReserve());

        /**
         * В случае ниже принцип подстановки Лисков не соблюдён из-за нарушение инвариантности.
         * То есть в классе-потомке не производится валидация данных, которые должны соответствовать
         * критериям на всём времени работы программы.
         */
        List<Child> children = new ArrayList<>(List.of(new Child("Ivan", LocalDateTime.now())));
        SomeKindergarten sg = new SomeKindergarten(children);
        sg.addChild(new Child("Mihail",
                LocalDateTime.of(2010, Month.MAY, 15, 11, 45))
        );
        System.out.println(sg.getChildren());
    }
}
