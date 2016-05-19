package br.edu.ifrn.postolegal.dominio;

import java.io.Serializable;
import java.util.Set;

import lombok.*;

import javax.persistence.*;

/**
 * @author jbull
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"licensePlate"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_vehicle", name = "ID_SEQUENCE", allocationSize = 1)
public class Vehicle implements Serializable, Comparable<Vehicle>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Singular
	@OneToMany(mappedBy = "vehicle")
	public Set<Consumption> consumptions;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_vehicle__user"))
	private User user;

	@Column(nullable = false)
	private Integer year;

	@Column(nullable = false, length = 10)
	private String engine;

	@Column(nullable = false, length = 30)
	private String model;

	@Column(nullable = false, length = 10)
	private String licensePlate;

	@Override
	public int compareTo(Vehicle vehicle)
	{
		int result = this.model.compareTo(vehicle.model);
		if (result == 0)
		{
			if ((result = this.year.compareTo(vehicle.year)) == 0)
				result = this.licensePlate.compareTo(vehicle.licensePlate);
		}
		return result;
	}
}
