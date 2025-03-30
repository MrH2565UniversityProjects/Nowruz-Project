package com.AP;

import com.AP.Pages.Page;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String, Page> routeMap = new HashMap<>();
    private Page currentPage;
    private String indexRoute = "Home";

    public String getIndexRoute() {
        return indexRoute;
    }

    public void setIndexRoute(String indexRoute) {
        this.indexRoute = indexRoute;
    }

    public void addRoute(String route, Page page) {
        routeMap.put(route, page);
    }
    public static Router CreateDefault(){
        return new Router();
    }
    public void navigate(String route) {
        Page nextPage = routeMap.get(route);
        if (nextPage != null) {
            currentPage = nextPage;
            currentPage.Render();
        } else {
            System.out.println("[ERROR] 404 not found: " + route);
        }
    }
    public void navigate(){
        navigate(indexRoute);
    }

    public Page getCurrentPage() {
        return currentPage;
    }
}
