package br.edu.ifrn.postolegal.domain;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_station", name = "ID_SEQUENCE", allocationSize = 1)
public class Station implements Serializable, Comparable<Station>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Singular
	@OneToMany(mappedBy = "station")
	private Set<StationProduct> products;

	@Column(nullable = false)
	private String name;

	private float latitude;

	private float longitude;

	@Override
	public int compareTo(Station station)
	{
		return station.id.compareTo(this.id);
	}
}
