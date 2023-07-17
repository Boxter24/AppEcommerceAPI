package com.Boxter24.EcommerceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "components_ecommerce")
@NoArgsConstructor
@AllArgsConstructor
public class ComponentEcommerce {

    private Long id;

    @Id
    private Long index;

    private String type;

    @OneToMany(mappedBy = "componentEcommerce", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DataComponentEcommerce> dataList;

}
