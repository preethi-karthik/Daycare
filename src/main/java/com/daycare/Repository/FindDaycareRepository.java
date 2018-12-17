/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Repository;

import com.daycare.Interface.FindDaycareRepositoryInterface;
import com.daycare.Model.Daycare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author preethi
 */
@Repository
public class FindDaycareRepository implements FindDaycareRepositoryInterface {

    public DataSource getDataSource() {
        return DataSourceBuilder.create().username("user1").password("Password!")
                .url("jdbc:mysql://localhost:3306/CHELP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    @Override
    public List<Daycare> getSearchResult(String state, String City, int userRating, String StartDate, String EndDate) {

        String Query = "{CALL chelp.SPFindDaycareWithDate(?,?,?,?,?)}";
        Connection cn = null;
        try {
            DataSource ds = getDataSource();
            cn = ds.getConnection();

            PreparedStatement ps = cn.prepareStatement(Query);
            ps.setInt(3, userRating);
            ps.setString(1, City);
            ps.setString(2, state);
            ps.setString(4, StartDate);
            ps.setString(5, EndDate);
            ResultSet rs = ps.executeQuery();
            List<Daycare> dc = new ArrayList<Daycare>();
            while (rs.next()) {
                Daycare d = new Daycare();
                d.setDaycareName(rs.getString(1));
                d.setAddress(rs.getString(2));
                d.setZipcode(rs.getString(3));
                d.setAvailableSeats(rs.getInt(4));
                d.setCostperday(rs.getFloat(5));
                d.setDate(rs.getString(6));
                dc.add(d);
            }
            rs.close();
            ps.close();
            return dc;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public List<Daycare> getSearchResult(String state, String City, int userRating) {
        String Query = "{CALL chelp.SPFindDaycareWithoutDate(?,?,?)}";
        Connection cn = null;
        try {
            DataSource ds = getDataSource();
            cn = ds.getConnection();
            PreparedStatement ps = cn.prepareStatement(Query);
            ps.setInt(3, userRating);
            ps.setString(1, City);
            ps.setString(2, state);
            ResultSet rs = ps.executeQuery();
            List<Daycare> dc1 = new ArrayList<Daycare>();
            while (rs.next()) {
                Daycare d = new Daycare();
                d.setDaycareName(rs.getString(1));
                d.setAddress(rs.getString(2));
                d.setZipcode(rs.getString(3));
                d.setAvailableSeats(rs.getInt(4));
                d.setCostperday(rs.getFloat(5));
                d.setDate(rs.getString(6));
                dc1.add(d);
            }
            rs.close();
            ps.close();
            return dc1;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    String Query2 = "select DC.Daycare_name,Dc.dc_address1 ,DC.dc_Zipcode ,DA.AvailableSeats,DA.CostPerDay"
            + "from chelp.DaycareAvailability DA inner join chelp.Daycare DC on DC.Daycare_id = DA.Daycare_Daycare_ID where DC.DC_City like '%Sacramento%' "
            + "and DC.DC_State  like '%California%'  and DC.TotalStarRating > 1  ";

    String Query5 = "select DC.Daycare_name,Dc.dc_address1 ,DC.dc_Zipcode ,DA.AvailableSeats,DA.CostPerDay,DA.Date\n"
            + "from chelp.DaycareAvailability DA inner join chelp.Daycare DC on DC.Daycare_id = DA.Daycare_Daycare_ID where DC.DC_City like '%Sacramento%' \n"
            + "and DC.DC_State  like '%California%'  and DC.TotalStarRating > 1  and (DA.Date >= '2018/12/9' and Da.Date < '2018/12/12') ";

}
