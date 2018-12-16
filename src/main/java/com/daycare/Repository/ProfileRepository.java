/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Repository;

import com.daycare.Interface.ProfileRepositoryInterface;
import com.daycare.Model.Profile;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 *
 * @author preethi
 */
public class ProfileRepository implements ProfileRepositoryInterface {

    public DataSource getDataSource() {
        return DataSourceBuilder.create().username("user1").password("Password!")
                .url("jdbc:mysql://localhost:3306/CHELP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    public Profile getuserid(int userid) {
        String Sql = "select up.Userid,up.First_Name,up.Middle_Name,up.Last_Name,up.Address_1,up.Address_2,up.City,up.State,up.Country,up.Zipcode,upEmail "
                + "from CHELP.userprofile up ; ";
        Connection cn = null;
        try {
            DataSource ds = getDataSource();
            cn = ds.getConnection();

            PreparedStatement ps = cn.prepareStatement(Sql);
            ps.setInt(1, userid);
            Profile profile = new Profile();

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                profile.setFirstName("");
                profile.setMiddleName("");
                profile.setLastName("");
                profile.setAddress1("");
                profile.setAddress2("");
                profile.setCity("");
                //profile.setStates(states);
                profile.setZipcode("");
                //profile.setPhonenumber();
                profile.setEmail("");

            }
            rs.close();
            ps.close();
            return profile;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }

        }

    }
}
