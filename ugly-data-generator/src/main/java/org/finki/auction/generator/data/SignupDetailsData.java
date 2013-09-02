package org.finki.auction.generator.data;

import org.finki.auction.generator.Data;
import org.ugly.entities.SignupDetails;
import org.ugly.entities.SignupDetails.Sex;

public class SignupDetailsData extends Data<SignupDetails> implements
		SignupDetails.Importer {

	@Override
	public void open() {
	}

	@Override
	public void close() {
	}

	@Override
	public SignupDetails newInstance() {
		return new SignupDetails(this);
	}

	@Override
	public String provideUsername() {
		return dataGenerator.getFirstName() + "_" + dataGenerator.getLastName();
	}

	@Override
	public String providePassword() {
		return dataGenerator.getRandomChars(5);
	}

	@Override
	public String provideConfirmPassword() {
		return dataGenerator.getRandomChars(5);
	}

	@Override
	public Sex provideSex() {
		return dataGenerator.getItem(Sex.values(), 10, Sex.Female);
	}

	@Override
	public boolean provideAgreedLegal() {
		return dataGenerator.getNumberBetween(1, 100) % 2 == 0 ? true : false;
	}

}
