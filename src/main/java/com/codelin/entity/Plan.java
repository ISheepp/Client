package com.codelin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lin
 * @create 2020-09-10 15:01
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Plan {

    private int id;
    private String clientname;
    private Date date;
    private String item;
}
