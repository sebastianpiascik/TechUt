package pl.spiascik.ug.app.service;

import java.util.List;

import pl.spiascik.ug.app.domain.Cloth;

public interface SellingManager {

	void addCloth(Cloth cloth);
	List<Cloth> getAllClothes();
	List<Cloth> getWaterproofClothes();
	void deleteCloth(Cloth cloth);
    Cloth findClothById(Long id);

}
