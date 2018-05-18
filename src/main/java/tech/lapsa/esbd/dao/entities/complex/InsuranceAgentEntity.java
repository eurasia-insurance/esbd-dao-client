package tech.lapsa.esbd.dao.entities.complex;

import java.util.function.Consumer;

import tech.lapsa.esbd.dao.entities.AEntity;
import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(97)
public class InsuranceAgentEntity extends AEntity {

    private static final long serialVersionUID = 1L;

    public static final InsuranceAgentEntityBuilder builder() {
	return new InsuranceAgentEntityBuilder();
    }

    public static final class InsuranceAgentEntityBuilder {

	private Integer id;

	private InsuranceAgentEntityBuilder() {
	}

	public InsuranceAgentEntityBuilder withId(final Integer id) {
	    this.id = MyNumbers.requirePositive(id, "id");
	    return this;
	}

	public InsuranceAgentEntity build() throws IllegalArgumentException {
	    final InsuranceAgentEntity res = new InsuranceAgentEntity();
	    res.id = MyNumbers.requirePositive(id, "id");
	    return res;
	}

	public void buildTo(final Consumer<InsuranceAgentEntity> consumer) throws IllegalArgumentException {
	    consumer.accept(build());
	}
    }

    private InsuranceAgentEntity() {
    }

    // id

    private Integer id;

    public Integer getId() {
	return id;
    }
}
