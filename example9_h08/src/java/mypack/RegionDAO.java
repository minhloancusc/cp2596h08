package mypack;

import java.util.List;

/**
 *
 * @author minhloan
 */
public interface RegionDAO {
    public List<Region> showAllRegion();
    public List<Region> findRegionbyDes(String des);
    public Region findRegionbyID(int id);
    public void insertRegion(Region r);
    public void editRegion(Region r);
    public void deleteRegion(int id);
    
}
