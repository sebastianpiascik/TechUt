package pl.spiascik.ug.app.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pl.spiascik.ug.app.domain.Cloth;
import pl.spiascik.ug.app.service.SellingManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class SellingManagerTest {

	@Autowired
	SellingManager sellingManager;

	@Test
	public void addClothCheck(){

        List<Cloth> retrievedClothes = sellingManager.getAllClothes();

		for (Cloth cloth : retrievedClothes) {
			if (cloth.getId().equals(1)) {
				sellingManager.deleteCloth(cloth);
			}
		}


	    Cloth cloth = new Cloth();
	    cloth.setName("Nazwa");
	    cloth.setPrice(10.12);
	    cloth.setProductionDate(new Date());
	    cloth.setWaterproof(true);
	    sellingManager.addCloth(cloth);
    }

    @Test
    public void deleteClothCheck(){
	    Long id = (long) 2;
	    Cloth retrievedCloth = sellingManager.findClothById(id);

	    sellingManager.deleteCloth(retrievedCloth);
    }
}
