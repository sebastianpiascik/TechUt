package pl.spiascik.ug.app.service;
import pl.spiascik.ug.app.domain.Cloth;

import java.sql.SQLException;
import java.util.List;

public interface ClothService {

    public void addCloth(Cloth cloth) throws SQLException;
    public void removeCloth(String name) throws SQLException;
    public List<Cloth> getListOfClothes() throws SQLException;
    public void showAllClothes() throws SQLException;
    public void showAllWaterproof() throws SQLException;
    public boolean addAllClothes(List<Cloth> clothes);
    public void searchName(String name) throws SQLException;


}
