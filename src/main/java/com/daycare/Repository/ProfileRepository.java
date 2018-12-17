/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Repository;

import com.daycare.Interface.ProfileRepositoryInterface;
import com.daycare.Model.ChildProfile;
import com.daycare.Model.Profile;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author preethi
 */
@Repository
public class ProfileRepository implements ProfileRepositoryInterface {

    public DataSource getDataSource() {
        return DataSourceBuilder.create().username("user1").password("Password!")
                .url("jdbc:mysql://localhost:3306/CHELP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    public Profile getuserid(int userid) {
        String Sql = "select up.Userid,up.First_Name,up.Middle_Name,up.Last_Name,up.Address_1,up.Address_2,up.City,up.State,up.Country,up.Zipcode,up.Email "
                + "from CHELP.userprofile up where up.Userid =? ; ";
        Connection cn = null;
        try {
            DataSource ds = getDataSource();
            cn = ds.getConnection();

            PreparedStatement ps = cn.prepareStatement(Sql);
            ps.setInt(1, userid);
            Profile profile = new Profile();

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                profile.setFirstName(rs.getString(2));
                profile.setMiddleName(rs.getString(3));
                profile.setLastName(rs.getString(4));
                profile.setAddress1(rs.getString(5));
                profile.setAddress2(rs.getString(6));
                profile.setCity(rs.getString(7));
                profile.setState(rs.getString(8));
                profile.setCountry(rs.getString(9));
                profile.setZipcode(rs.getString(10));
                //profile.setPhonenumber();
                profile.setEmail(rs.getString(11));

                ArrayList<ChildProfile> childlist = new ArrayList<>();
         
                String query = "select ch.Child_ID,CH_MName,ch.CH_FNAME ,ch.CH_LNAME,ch.Gender,ch.age,ch.DOB,ch.BloodGroup from chelp.child  ch where ch.UserProfile_userid = ? ;";
                Connection c = null;
                try {
                   
                    DataSource d = getDataSource();
                    c = d.getConnection();
                    PreparedStatement p = c.prepareStatement(query);
                    p.setInt(1, userid);
                    ResultSet r = p.executeQuery();
                     while (r.next()) {
                          ChildProfile cp = new ChildProfile();
                     cp.setChildId(r.getInt(1));
                     cp.setChildFirstName(r.getString(3));
                     cp.setChildMiddleName(r.getString(2));
                     cp.setChildLastName(r.getString(4));
                     cp.setChildGender(r.getString(5));
                     cp.setChildAge(r.getInt(6));
                     cp.setChildDateOfBirth(r.getString(7));
                     cp.setBloodGroup(r.getString(8));
                     childlist.add(cp);
                     }
                     r.close();
                     p.close();

                } catch (Exception e) {
                   throw new RuntimeException(e);
                } finally{
                    if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
                }              
                profile.setChildren(childlist);

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
