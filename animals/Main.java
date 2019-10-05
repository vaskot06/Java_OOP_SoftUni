import animals.Animal;
import animals.Dog;
import animals.Kitten;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Kitten("share", 93);
        Animal do2g = new Dog("share", 93, "Male");

        System.out.println(dog);
        System.out.println(do2g);
    }
}
