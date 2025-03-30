package com.AP;

import java.util.ArrayList;
import java.util.List;
public class Application {
    private Router router;
    public Application(Router router){
        this.router = router;
    }
    public Application(){
        router = Router.CreateDefault();
    }
    public Router getRouter() {
        return router;
    }
    public void Run(){
        router.navigate();
    }
    public static Application CreateDefault(){
        return new Application();
    }
    public static Application Create(){
        return new Application();
    }
}
