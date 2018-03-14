package fr.mb.projet.action;

import fr.mb.projet.contract.ManagerFactory;

public abstract class Helper {

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}