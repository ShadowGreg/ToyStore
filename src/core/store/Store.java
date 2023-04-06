package core.store;

import core.toy.Toyable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Store implements Storeble{

    private List<Toyable> toys;
    private List<PriorityQueue<Toyable>> shelvesToys;

    public Store(List<Toyable> toys) {
        this.toys = new LinkedList<>(toys);
        shelvesToys = new ArrayList<>();
        FillShelvesToys(toys);
    }

    public List<Toyable> getToys() {
        return toys;
    }

    public void AddToy(Toyable inToy) {
        RefactorToysWeight(inToy);
        FillShelvesToys(this.toys);
    }

    public Toyable GetToy(Toyable inToy) {
        int index = 0;
        for (PriorityQueue<Toyable> item : shelvesToys) {
            index++;
            if (item.size()!=0){
                Toyable temp = item.element();
                if (item.element().equals(inToy)) {
                    if (item.size() == 1) {
                        shelvesToys.remove(index);
                        toys.remove(inToy);
                    }
                    item.remove();
                    return inToy;
                }
            }
        }
        return null;
    }

    private void FillShelvesToys(List<Toyable> toys) {
        for (Toyable item : toys) {
            shelvesToys.add(FillToysQueue(item));
        }
    }

    private PriorityQueue<Toyable> FillToysQueue(Toyable item) {
        PriorityQueue<Toyable> out = new PriorityQueue<>();
        for (int i = 0; i < item.getQuantity(); i++) {
            out.add(item);
        }
        return out;
    }

    private void RefactorToysWeight(Toyable inToy) {
        int totalSum = 100;
        List<Integer> existingWeights = new ArrayList<>();
        List<Integer> newWeights = new ArrayList<>();

        for (Toyable item : this.toys) {
            existingWeights.add(item.getWeight());
        }
        existingWeights.add(inToy.getWeight());

        int newTotalSum = existingWeights.stream()
                .flatMapToInt(IntStream::of)
                .sum();

        ResizeWeights(totalSum, existingWeights, newWeights, (double) newTotalSum);

        int tempSum = newWeights.stream()
                .flatMapToInt(IntStream::of)
                .sum();

        newWeights.add(totalSum - tempSum);

        this.toys.add(inToy);

        SetWeights(newWeights);
    }

    private static void ResizeWeights(int totalSum, List<Integer> existingWeights, List<Integer> newWeights, double newTotalSum) {
        for (int i = 0; i < existingWeights.size() - 1; i++) {
            double temp = (totalSum / newTotalSum * existingWeights.get(i));
            newWeights.add((int) temp);
        }
    }

    private void SetWeights(List<Integer> newWeights) {
        if (newWeights.size() == this.toys.size()) {
            for (int i = 0; i < this.toys.size(); i++) {
                this.toys.get(i).setWeight(newWeights.get(i));
            }
        }
    }

}
