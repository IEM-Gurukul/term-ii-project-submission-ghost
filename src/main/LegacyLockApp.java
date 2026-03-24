package main;

import gui.LoginGUI;
import monitor.VaultMonitor;

public class LegacyLockApp {

    public static void main(String[] args) {

        
        VaultMonitor monitor = new VaultMonitor();
        monitor.start();

        
        new LoginGUI();
    }
}