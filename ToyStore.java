import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToyStore {
    private ArrayList<Toy> toys = new ArrayList<>(); // Список игрушек в магазине
    private ArrayList<Toy> prizeToys = new ArrayList<>(); // список призов

    
    /**
     * метод добавления игрушки в магазин
     */
    public void addToys(Toy toy) {
        toys.add(toy);
    }

    /**
     * метод изменения веса игрушки по индефикатору
     * 
     */
    public void setToyWeiht(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    /**
     * метод получения приза
     */
    public Toy getPrizeToy() {
        Toy prize = prizeToys.get(0);
        prizeToys.remove(0);
        return prize;
    }

    /**
     * метод розыгрыша
     */
    public void startLottery() {
        Random random = new Random();
        int totalWeight = 0;

        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        while (!toys.isEmpty()) {
            int randomNumber = random.nextInt(totalWeight);
            int currenrWeight = 0;

            for (Toy toy : toys) {
                currenrWeight += toy.getWeight();

                if (currenrWeight > randomNumber) {
                    prizeToys.add(toy);
                    toys.remove(toy);

                    try{
                        File file = new File("prizeToys.txt");
                        FileWriter writer = new FileWriter(file,true);
                        
                        writer.write(toy.toString() +"\n");
                        writer.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            totalWeight -= randomNumber;
        }

        
    }


}
