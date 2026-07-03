package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhloan
 */
public class RegionDAOImp implements RegionDAO{

    @Override
    public List<Region> showAllRegion(){
        List<Region> listRegion = new ArrayList<>();
        try {            
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Region r = new Region(rs.getInt("RegionID"), rs.getString("RegionDescription"));
                listRegion.add(r);
            }
            conn.close();
            return listRegion;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listRegion;
    }

    @Override
    public List<Region> findRegionbyDes(String des) {
        return null;
    }

    @Override
    public Region findRegionbyID(int id) {
        Region region = null;
        try {            
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region where RegionID=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                region = new Region(rs.getInt("RegionID"), rs.getString("RegionDescription"));              
            }
            conn.close();
            return region;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return region;
    }

    @Override
    public void insertRegion(Region r) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "insert into Region (RegionID,RegionDescription) values (?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, r.getRegionID());
            pstm.setString(2, r.getRegionDescription());
            pstm.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }        
    }

    @Override
    public void editRegion(Region r) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "update Region set RegionDescription=? where RegionID=?";
            PreparedStatement pstm = conn.prepareStatement(sql);            
            pstm.setString(1, r.getRegionDescription());
            pstm.setInt(2, r.getRegionID());
            pstm.executeUpdate();
            conn.close();
            System.out.println("Update thanh cong");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteRegion(int id) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "delete Region where RegionID=?";            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            int i = pstm.executeUpdate();            
            System.out.println("Delete thanh cong");
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
