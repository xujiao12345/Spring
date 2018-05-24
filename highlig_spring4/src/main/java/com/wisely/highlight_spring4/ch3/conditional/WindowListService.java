package com.wisely.highlight_spring4.ch3.conditional;

public class WindowListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
