package fr.mb.projet;

import fr.mb.projet.contract.ManagerFactory;

public class  Helper {
	
	private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
