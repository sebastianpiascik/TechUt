package pl.spiascik.ug.app.service;

import java.util.List;

import pl.spiascik.ug.app.domain.Cloth;

public interface ClothesManager {

	void addCloth(Cloth cloth);
	List<Cloth> getAllClothes();
	void deleteCloth(Cloth cloth);
    Cloth findClothById(Long id);

}
