package com.Boxter24.EcommerceAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "data_components_ecommerce")
@NoArgsConstructor
@AllArgsConstructor
public class DataComponentEcommerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_ecommerce_index")
    private ComponentEcommerce componentEcommerce;

    public InnerObject getComponentEcommerce(){

        OuterObject myObject = new OuterObject();
        InnerObject innerObject = new InnerObject();
        innerObject.setIndex(componentEcommerce.getIndex());
        myObject.setComponentEcommerce(innerObject);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(myObject);
        } catch (JsonProcessingException e) {
            // manejar la excepción aquí
        }

        return myObject.getComponentEcommerce();
    }

    @JsonIgnore
    public Long getIndexComponentEcommerce(){
        return componentEcommerce.getIndex();
    }

}

class OuterObject {
    private InnerObject componentEcommerce;

    public InnerObject getComponentEcommerce() {
        return componentEcommerce;
    }

    public void setComponentEcommerce(InnerObject componentEcommerce) {
        this.componentEcommerce = componentEcommerce;
    }
}

class InnerObject {
    private Long index;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}
