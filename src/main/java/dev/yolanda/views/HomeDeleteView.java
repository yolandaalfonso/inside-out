package dev.yolanda.views;

public class HomeDeleteView extends View{
    public static void printDeleteMenu() {
        System.out.println("Ingresa el identificador del momento:");
        int id = SCANNER.nextInt();

        System.out.println("Momento vivido añadido correctamente");
        HomeView.printMenu();
    }
}
