package com.AP;

import com.AP.Pages.Page;

public class RouteEntry {
    private final Page page;
    private String requiredRole = null;

    public RouteEntry(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public String getRequiredRole() {
        return requiredRole;
    }

    public RouteEntry requireRole(String role) {
        this.requiredRole = role;
        return this;
    }

    public boolean isAccessGranted() {
        if (requiredRole == null) return true;
        return Session.getInstance().isLoggedIn() && Session.getInstance().getCurrentAccount().hasRole(requiredRole);
    }

}

