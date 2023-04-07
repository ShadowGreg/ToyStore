package view;

import core.toy.Toyable;

public class View implements Viewable{

    public static void done() {
        System.out.println("Готово >\n");
    }
    public static void startRead(){
        System.out.println("Считываем файл с грушками >\n");
    }
    public static void createStore() {
        System.out.println("Заполняем полки игрушками >\n");
    }
    public static void createLottery() {
        System.out.println("Организуем лоттерею >\n");
    }

    public static void startLottery() {
        System.out.println("Начинаем розыгрыш лоттерии >\n");
    }

    static void raundLottery(int i, Toyable toy){
        System.out.println(String.format("В %d раунде лоттерии выпа>\n",i));
        System.out.println(String.format("%s\n",toy.toString()));
    }

    static void writeLottery() {
        System.out.println("Записываем результаты розыгрышей лоттерии >\n");
    }

}
