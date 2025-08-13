package dev.yolanda.controllers;

import dev.yolanda.views.HomeView;

public class HomeController {

    public HomeController() {
        index();
    }
    
    public void index() {
        HomeView.printMenu();
    }
}
