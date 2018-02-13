package com.renhai.notes.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by hai on 2/12/18.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "note")
public class Note {

	@Id
	private String id;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String notes;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
}
