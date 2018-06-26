package fr.dauphine.miageIfAsm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TauxChange implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String source;
	private String dest;
	private double taux;
	private Date date;
	
}