package com.example.demo.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustomerOrder.class)
public abstract class CustomerOrder_ {

	public static volatile SingularAttribute<CustomerOrder, String> customerAddress;
	public static volatile SingularAttribute<CustomerOrder, String> customerEmail;
	public static volatile SingularAttribute<CustomerOrder, Long> id;
	public static volatile SingularAttribute<CustomerOrder, Date> orderDate;
	public static volatile ListAttribute<CustomerOrder, OrderItem> items;
	public static volatile SingularAttribute<CustomerOrder, String> deliveryStatus;

	public static final String CUSTOMER_ADDRESS = "customerAddress";
	public static final String CUSTOMER_EMAIL = "customerEmail";
	public static final String ID = "id";
	public static final String ORDER_DATE = "orderDate";
	public static final String ITEMS = "items";
	public static final String DELIVERY_STATUS = "deliveryStatus";

}

