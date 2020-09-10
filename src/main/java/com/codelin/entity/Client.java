package com.codelin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Client {

    private int id;
    private String name;
    private String contribution;
    private String level;
    private String location;
    private String manager;
    private String phone;

}
