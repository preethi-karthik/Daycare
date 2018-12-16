/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Repository;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 *
 * @author preethi
 */
public class ChildProfileRepository {
    public DataSource getDataSource() {
        return DataSourceBuilder.create().username("user1").password("Password!")
                .url("jdbc:mysql://localhost:3306/CHELP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }
    
    
    
}
