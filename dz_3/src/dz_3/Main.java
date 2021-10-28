package dz_3;

public class Main {
    public static void main(String[] args) {

        // if coordinates cage isn't correct
        try {
            Cage c1 = new Cage(11, 2);

            System.out.println(c1.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Введите корректные координаты!");
        } catch (Exception e) {}

        // if coordinates cage is correct, but changing x value isn't correct
        try {
            Cage c1 = new Cage(1, 2);
            c1.setX(8);

            System.out.println(c1.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Нельзя изменить значение x на 8!");
        } catch (Exception e) {}

        // if coordinates cage is correct, but changing y value isn't correct
        try {
            Cage c1 = new Cage(1, 2);
            c1.setY(-1);

            System.out.println(c1.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Нельзя изменить значение y на -1!");
        } catch (Exception e) {}

        // if all is correct
        try {
            Cage c1 = new Cage(1, 0);
            c1.setY(1);

            System.out.println(c1.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Нельзя изменить значение y на -1!");
        } catch (Exception e) {}
    }
}
