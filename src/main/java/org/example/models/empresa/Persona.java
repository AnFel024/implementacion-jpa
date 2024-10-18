package org.example.models.empresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
    //@Id
    //private UUID id;
    private String nombre;
    @Id
    @Column(nullable = false)
    private Long cedula;
}
