package dev.yolanda.views;

public class MomentFilterView extends View{
    //private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {

        String text = """
                Filtrar por...
                1.Emoción
                2.Fecha
                3.Mood
                Ingresa una opcion:
                """;
        
        System.out.print(text);
        int option = SCANNER.nextInt();

        if (option == 1) FilterEmotionView.filterByEmotion();
        if (option == 2) FilterDateView.filterByDate();

        //CONTROLLER.deleteMoment(id);

        HomeView.printMenu();
    }

}
