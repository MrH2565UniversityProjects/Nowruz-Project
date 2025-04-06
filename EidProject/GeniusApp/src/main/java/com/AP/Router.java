package com.AP;

import com.AP.Pages.Page;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String, RouteEntry> routeMap = new HashMap<>();
    private Page currentPage;
    private String indexRoute = "Home";
    private static Router instance;
    public static Router getInstance(){
        if(instance == null)
            instance = new Router();
        return instance;
    };
    public RouteEntry addRoute(String route, Page page) {
        RouteEntry entry = new RouteEntry(page);
        routeMap.put(route, entry);
        return entry;
    }

    public void navigate(String route,Object... params) {
        RouteEntry entry = routeMap.get(route);
        if (entry == null) {
            System.out.println("[ERROR] 404 not found: " + route);
            return;
        }

        if (!entry.isAccessGranted()) {
            System.out.println("[ERROR] Access denied. Please login with proper role.");
            return;
        }

        currentPage = entry.getPage();
        currentPage.Render(params);
    }

    public void navigate() {
        navigate(indexRoute);
    }

    public Page getCurrentPage() {
        return currentPage;
    }
}

