/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Repository;

import com.daycare.Interface.ChildProfileRepositoryInterface;
import com.daycare.Model.ChildProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author preethi
 */
@Repository
public class ChildProfileRepository implements ChildProfileRepositoryInterface{
    public DataSource getDataSource() {
        return DataSourceBuilder.create().username("user1").password("Password!")
                .url("jdbc:mysql://localhost:3306/CHELP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    @Override
    public ChildProfile getchildid(int childid) {
        String Sql = "select ch.Child_ID,ch.CH_FNAME ,CH_MName,ch.CH_LNAME,ch.Gender,ch.age,ch.DOB,ch.BloodGroup from chelp.child  ch where ch.child_id = ?";
           
        Connection cn = null;
        try {
            DataSource ds = getDataSource();
            cn = ds.getConnection();

            PreparedStatement ps = cn.prepareStatement(Sql);
            ps.setInt(1, childid);
            ChildProfile cp = new ChildProfile();

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
             cp.setChildFirstName(rs.getString(2));
             cp.setChildMiddleName(rs.getString(3));
             cp.setChildLastName(rs.getString(4));
             cp.setChildGender(rs.getString(5));
             cp.setChildAge(rs.getInt(6));
             cp.setChildDateOfBirth(rs.getString(7));
             cp.setBloodGroup(rs.getString(8));                          
            }
            return cp;
        }catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }

        }
    }   
    
}
