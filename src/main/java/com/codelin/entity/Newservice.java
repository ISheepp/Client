package com.codelin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lin
 * @create 2020-09-11 8:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Newservice {

    private int id;
    private String clientname;
    private String type;
    private String outline;
    private String status;
    private String createperson;
    private Date createtime;
    private String request;
    private String dealperson;
}
