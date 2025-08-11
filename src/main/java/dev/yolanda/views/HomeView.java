package dev.yolanda.views;

public class HomeView extends View{

    public static void printMenu() {

        String text = """
                My diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                """;

        System.out.print(text);

        int option = SCANNER.nextInt();

        if (option == 1) MomentPostView.printStoreMenu();


    }
    
}
