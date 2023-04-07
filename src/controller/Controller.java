package controller;

import core.store.Store;
import core.toy.Toyable;
import fileController.ReadFile;
import fileController.WriteFile;
import lottery.Lottery;
import view.Viewable;

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
        Viewable.startRead();
        List<Toyable> toys = fileReader.readJson();
        Viewable.done();

        Viewable.createStore();
        Store store = new Store(toys);
        Viewable.done();

        Viewable.createLottery();
        Lottery lottery = new Lottery(store);
        Viewable.done();

        Viewable.startLottery();
        int lotteryDraws = 10;
        for (int i = 0; i < lotteryDraws; i++) {
            Toyable toy = lottery.GetToy();
            Viewable.raundLottery(i,toy);
            fellOutToys.add(toy);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }
        Viewable.done();

        Viewable.writeLottery();
        fileWriter.WriteToFile(fellOutToys);
        Viewable.done();
    }
}
