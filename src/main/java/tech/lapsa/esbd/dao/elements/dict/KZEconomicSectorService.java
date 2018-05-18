package tech.lapsa.esbd.dao.elements;

import javax.ejb.Local;
import javax.ejb.Remote;

import com.lapsa.kz.economic.KZEconomicSector;

public interface KZEconomicSectorService extends ElementsService<KZEconomicSector> {

    public static final String BEAN_NAME = "KZEconomicSectorServiceBean";

    @Local
    public interface KZEconomicSectorServiceLocal
	    extends ElementsServiceLocal<KZEconomicSector>, KZEconomicSectorService {
    }

    @Remote
    public interface KZEconomicSectorServiceRemote
	    extends ElementsServiceRemote<KZEconomicSector>, KZEconomicSectorService {
    }
}
