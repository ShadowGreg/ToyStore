package view;

import core.toy.Toyable;

public class View{

    public static String done() {
        return "Готово >\n";
    }
    public static String startRead(){
        return "Считываем файл с грушками >\n";
    }
    public static String createStore() {
        return "Заполняем полки игрушками >\n";
    }
    public static String createLottery() {
        return "Организуем лоттерею >\n";
    }

    public static String startLottery() {
        return "Начинаем розыгрыш лоттерии >\n";
    }

    public static String raundLottery(int i, Toyable toy){
        return String.format("В %d раунде лоттерии выпала игрушка>\n > %s \n",i+1, toy.toString().split(";")[1]);
    }

    public static String writeLottery() {
        return "Записываем результаты розыгрышей лоттерии >\n";
    }

}
