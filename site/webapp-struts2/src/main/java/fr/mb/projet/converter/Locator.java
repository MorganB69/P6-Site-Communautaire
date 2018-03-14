package fr.mb.projet.converter;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.NotFoundException;

public class Locator extends StrutsTypeConverter {
	
    @Inject
    private ManagerFactory managerFactory;

	@Override
	public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
		Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                        = StringUtils.isEmpty(vValue)
                        ? null
                        :  managerFactory.getSiteManager().getSite(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }
        return vRetour;
	}

	@Override
	public String convertToString(Map pContext, Object pObject) {
		String vString;
        if (pObject instanceof Site) {
            Site vSite = (Site) pObject;
            vString
                = vSite.getId() != null
                ? vSite.getId().toString()
                : "";
        } else {
            vString = "";
        }
        return vString;
	}

}
