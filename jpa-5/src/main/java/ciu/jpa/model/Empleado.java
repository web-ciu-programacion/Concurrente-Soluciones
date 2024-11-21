package ciu.jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Empleado extends Persona {

	private Integer numeroDeLegajo;

	public Integer getNumeroDeLegajo() {
		return numeroDeLegajo;
	}

	public void setNumeroDeLegajo(Integer numeroDeLegajo) {
		this.numeroDeLegajo = numeroDeLegajo;
	}
}
