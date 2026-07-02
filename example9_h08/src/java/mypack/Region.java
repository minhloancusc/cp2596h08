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
public class Region {
    private int regionID;
    private String regionDescription;
    
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
    
    public Region() {
        this.regionID = 0;
        this.regionDescription = null;
    }

    public Region(int regionID, String regionDescription) {
        this.regionID = regionID;
        this.regionDescription = regionDescription;
    }
        
    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }
    
}
