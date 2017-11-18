package edu.buffalo.cse.ood.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Component
@Scope("prototype")
public class BuyXGetYDeal<X extends Item,Y extends Item> extends Deal{

	@ManyToOne(targetEntity= Item.class)
	private X itemX;
	private long quantityX;
	@ManyToOne(targetEntity= Item.class)
	private Y itemY;
	private long quantityY;
}
