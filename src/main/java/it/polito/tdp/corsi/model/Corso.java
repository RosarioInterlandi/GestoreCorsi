package it.polito.tdp.corsi.model;

import java.util.Objects;

public class Corso {
	private String codins;
	private int credits;
	private String name;
	private int period;
	
	public Corso(String codins, int credits, String name, int period) {
		super();
		this.codins = codins;
		this.credits = credits;
		this.name = name;
		this.period = period;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codins, other.codins);
	}

	@Override
	public String toString() {
		return "Corso [codins=" + codins + ", credits=" + credits + ", name=" + name + ", period=" + period + "]";
	}
	
	
}
