package test.elements;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static test.entities.TestConstants.*;

import javax.inject.Inject;
import javax.naming.NamingException;

import org.junit.Test;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.esbd.services.NotFound;
import com.lapsa.insurance.esbd.services.elements.IdentityCardTypeServiceDAO;
import com.lapsa.insurance.esbd.services.impl.elements.mapping.IdentityCardTypeMapping;

import test.ArquillianBaseTestCase;

public class IdentityCardTypeServiceTestCase extends ArquillianBaseTestCase {

    @Inject
    private IdentityCardTypeServiceDAO service;

    @Test
    public void testGetById() throws NamingException {
	for (int id : IdentityCardTypeMapping.getInstance().getAllIds()) {
	    try {
		IdentityCardType res = service.getById(id);
		assertThat(res, allOf(not(nullValue()), equalTo(IdentityCardTypeMapping.getInstance().forId(id))));
	    } catch (NotFound e) {
		fail(e.getMessage());
	    }
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	service.getById(INVALID_IDENTITY_CARD_TYPE_ID);
    }
}
