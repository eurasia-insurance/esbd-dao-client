package tech.lapsa.esbd.dao.entities;

import java.time.LocalDate;
import java.util.function.Consumer;

import com.lapsa.insurance.elements.IdentityCardType;

import tech.lapsa.esbd.dao.Domain;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(59)
public class IdentityCardInfo extends Domain {

    private static final long serialVersionUID = 1L;

    public static final IdentityCardInfoBuilder builder() {
	return new IdentityCardInfoBuilder();
    }

    public static final class IdentityCardInfoBuilder {

	private LocalDate dateOfIssue;
	private String issuingAuthority;
	private String number;
	private IdentityCardType identityCardType;

	private IdentityCardInfoBuilder() {
	}

	public IdentityCardInfoBuilder withDateOfIssue(final LocalDate dateOfIssue) {
	    this.dateOfIssue = MyObjects.requireNonNull(dateOfIssue, "dateOfIssue");
	    return this;
	}

	public IdentityCardInfoBuilder withIssuingAuthority(final String issuingAuthority) {
	    this.issuingAuthority = issuingAuthority;
	    return this;
	}

	public IdentityCardInfoBuilder withNumber(final String number) {
	    this.number = MyStrings.requireNonEmpty(number, "number");
	    return this;
	}

	public IdentityCardInfoBuilder withIdentityCardType(final IdentityCardType identityCardType) {
	    this.identityCardType = MyObjects.requireNonNull(identityCardType, "identityCardType");
	    return this;
	}

	public IdentityCardInfo build() {
	    final IdentityCardInfo res = new IdentityCardInfo();
	    res.dateOfIssue = MyObjects.requireNonNull(dateOfIssue, "dateOfIssue");
	    res.issuingAuthority = issuingAuthority;
	    res.number = MyStrings.requireNonEmpty(number, "number");
	    res.identityCardType = MyObjects.requireNonNull(identityCardType, "identityCardType");
	    return res;
	}

	public void buildTo(final Consumer<IdentityCardInfo> consumer) {
	    consumer.accept(build());
	}
    }

    private IdentityCardInfo() {
    }

    // dateOfIssue

    private LocalDate dateOfIssue;

    public LocalDate getDateOfIssue() {
	return dateOfIssue;
    }

    // issuingAuthority

    private String issuingAuthority;

    public String getIssuingAuthority() {
	return issuingAuthority;
    }

    // number

    private String number;

    public String getNumber() {
	return number;
    }

    // identityCardType

    private IdentityCardType identityCardType;

    public IdentityCardType getIdentityCardType() {
	return identityCardType;
    }
}
