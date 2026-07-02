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
        return null;
    }

    @Override
    public void insertRegion(Region r) {
        
    }

    @Override
    public void editRegion(Region r) {
        
    }

    @Override
    public void deleteRegion(int id) {
        
    }

}
