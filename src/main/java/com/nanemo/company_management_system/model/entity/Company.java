package com.nanemo.company_management_system.model.entity;

import com.nanemo.company_management_system.util.LocalDateConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Convert(converter = LocalDateConverter.class)
    @Column(name = "create_date")
    private LocalDate createDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> userList;
}
