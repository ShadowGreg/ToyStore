package controller;

import core.store.Store;
import core.toy.Toyable;
import fileController.ReadFile;
import fileController.WriteFile;
import lottery.Lottery;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller<T extends Toyable> {
    private final WriteFile fileWriter;
    private final ReadFile fileReader;


    public Controller(String fileRead, String fileWrite) {
        fileWriter = new WriteFile(fileWrite);
        fileReader = new ReadFile(fileRead);
    }

    public void run() {
        List<Toyable> fellOutToys = new ArrayList<>();
        System.out.println(View.startRead());
        List<Toyable> toys = fileReader.readJson();
        System.out.println(View.done());

        System.out.println(View.createStore());
        Store store = new Store(toys);
        System.out.println(View.done());

        System.out.println(View.createLottery());
        Lottery lottery = new Lottery(store);
        System.out.println(View.done());

        System.out.println(View.startLottery());
        int lotteryDraws = 10;
        for (int i = 0; i < lotteryDraws; i++) {
            Toyable toy = lottery.GetToy();
            System.out.println(View.raundLottery(i,toy));
            fellOutToys.add(toy);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
        System.out.println(View.done());

        System.out.println(View.writeLottery());
        fileWriter.WriteToFile(fellOutToys);
        System.out.println(View.done());
    }
}
