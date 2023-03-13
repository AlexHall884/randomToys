
public class main {

    public static void main(String[] args){

        ToyStore casino777 = new ToyStore();

        casino777.addToys(new Toy(1, "Кукла Маша", 5, 20));
        casino777.addToys(new Toy(2, "Бибика", 15, 30));
        casino777.addToys(new Toy(3, "Lego", 10, 10));

        casino777.setToyWeiht(2, 10);

        casino777.startLottery();

        Toy prizeToy = casino777.getPrizeToy();
        
        System.out.println("Поздравляем! Вы выйграли: " + prizeToy.getName());
    }

    

}

