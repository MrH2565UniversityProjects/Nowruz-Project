package com.AP;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public Application(){
    }

    public void Run(){
        Router.getInstance().navigate();
    }
    public static Application CreateDefault(){
        return new Application();
    }
    public static Application Create(){
        return new Application();
    }
}
