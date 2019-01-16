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
import pl.spiascik.ug.app.domain.Type;
import pl.spiascik.ug.app.domain.Wearer;
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


	    Cloth cloth = new Cloth("Nazwa", "2018-12-01", 12.00,false);


        Type type1 = new Type("t-shirt");
        Wearer wearer = new Wearer("Jan", 1990);
        cloth.getWearers().add(wearer);
        cloth.setType(type1);

	    sellingManager.addCloth(cloth);
        System.out.println("============");
        System.out.println(cloth);
        System.out.println("============");
    }

    @Test
    public void deleteClothCheck(){
	    Long id = (long) 1;
	    Cloth retrievedCloth = sellingManager.findClothById(id);

	    if(retrievedCloth == null){
            System.out.println("Nie znaleziono ubrania z id:"+id);
            return;
        } else{
            sellingManager.deleteCloth(retrievedCloth);
            System.out.println("Usunieto ubranie z id:"+id);
        }

    }

    @Test
    public void getAllClothesCheck(){
	    List<Cloth> clothes = sellingManager.getAllClothes();
        System.out.println("============ All");
	    for(Cloth c : clothes){
            System.out.println(c);
        }
        System.out.println("============");
    }

    @Test
    public void getWaterproofClothesCheck(){
        List<Cloth> clothes = sellingManager.getWaterproofClothes();
        System.out.println("============ Waterpoof");
        for(Cloth c : clothes){
            System.out.println(c);
        }
        System.out.println("============");
    }
}
