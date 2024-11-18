package ma.enset.customerservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Customer.class)
public interface CostumerProjection {
    Long getId();
    String getName();

}
