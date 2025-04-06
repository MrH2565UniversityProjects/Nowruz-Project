package com.AP.Pages;

public abstract class Page {
    private String name;

    public Page() {
        Initialize();
    }

    protected abstract void Initialize();

    protected abstract void ShowContent(Object[] params);

    public final void Render(Object[] params) {
        PreRender();
        ShowContent(params);
    }

    protected void PreRender() {
        System.out.println("=== " + name + " ===");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
