package com.AP;

import com.AP.Pages.Page;

import java.util.*;

public class Router {
    private final Map<String, RouteEntry> routeMap = new HashMap<>();
    private final Deque<RouteState> history = new ArrayDeque<>();
    private RouteState currentPage;
    private String indexRoute = "Home";
    private static Router instance;

    public static Router getInstance() {
        if (instance == null)
            instance = new Router();
        return instance;
    }

    public RouteEntry addRoute(String route, Page page) {
        RouteEntry entry = new RouteEntry(page);
        routeMap.put(route, entry);
        return entry;
    }

    public void navigate(String route, Object... params) {
        RouteEntry entry = routeMap.get(route);
        if (entry == null) {
            System.out.println("[ERROR] 404 not found: " + route);
            return;
        }

        if (!entry.isAccessGranted()) {
            System.out.println("[ERROR] Access denied. Please login with proper role.");
            return;
        }

        if (currentPage != null && currentPage.page.ShouldSaveInHistory()) {
            history.push(currentPage);
        }
        currentPage = new RouteState(entry.getPage(),route,params);
        currentPage.page.Render(params);
    }

    public void goBack() {
        if (history.isEmpty()) {
            System.out.println("[INFO] No previous page in history.");
            return;
        }

        RouteState previous = history.pop();
        currentPage = previous;
        currentPage.page.Render(previous.params());
    }

    public void navigate() {
        navigate(indexRoute);
    }

    public Page getCurrentPage() {
        return currentPage.page;
    }

    private record RouteState(Page page, String route, Object[] params) {}
}
