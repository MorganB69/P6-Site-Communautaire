package fr.mb.projet.contract;

import fr.mb.projet.bean.Site;
import fr.mb.projet.recherche.RechercheSite;

public interface SiteDao {

	int getCountSite(RechercheSite pRechercheSite);

	Site getSite(int SiteId);

}
