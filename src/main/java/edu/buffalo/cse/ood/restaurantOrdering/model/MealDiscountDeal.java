package edu.buffalo.cse.ood.restaurantOrdering.model;

import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Component
@Scope("prototype")
@JsonDeserialize(as = MealDiscountDeal.class)
public class MealDiscountDeal extends Deal{

}
