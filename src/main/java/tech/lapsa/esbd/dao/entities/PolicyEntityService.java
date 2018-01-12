package tech.lapsa.esbd.dao.entities;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tech.lapsa.esbd.dao.NotFound;
import tech.lapsa.java.commons.exceptions.IllegalArgument;

public interface PolicyEntityService extends GeneralEntityService<PolicyEntity, Integer> {

    public static final String BEAN_NAME = "PolicyEntityServiceBean";

    @Local
    public interface PolicyEntityServiceLocal
	    extends GeneralEntityServiceLocal<PolicyEntity, Integer>, PolicyEntityService {
    }

    @Remote
    public interface PolicyEntityServiceRemote
	    extends GeneralEntityServiceRemote<PolicyEntity, Integer>, PolicyEntityService {
    }

    PolicyEntity getByNumber(String number) throws IllegalArgument, NotFound;

    List<PolicyEntity> getByInternalNumber(String internalNumber) throws IllegalArgument;
}
