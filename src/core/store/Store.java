package core.store;

import core.toy.Toyable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Store implements Storeble {

    private List<Toyable> toys;


    public Store(List<Toyable> toys) {
        this.toys = new LinkedList<>(toys);
    }

    public List<Toyable> getToys() {
        return toys;
    }

    public void AddToy(Toyable inToy) {
        RefactorToysWeight(inToy);
    }

    public Toyable GetToy(Toyable inToy) {
        int index = 0;
        int saveIndex = -1;
        if (this.toys.contains(inToy)) {
            for (Toyable item : this.toys) {
                if (item.equals(inToy)) {
                    item.ReduceAmount();
                    if (item.getQuantity() == 0) {
                        saveIndex = index;
                    }
                }
                index++;
            }
            if (saveIndex != -1 && this.toys.get(saveIndex).getQuantity() == 0) {
                this.toys.remove(saveIndex);
            }

            return inToy;
        }
        return null;
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
