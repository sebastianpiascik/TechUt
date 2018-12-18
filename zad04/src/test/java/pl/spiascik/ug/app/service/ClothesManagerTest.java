package pl.spiascik.ug.app.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class ClothesManagerTest {

	@Autowired
    ClothesManager clothesManager;

	@Test
	public void addClothCheck() throws ParseException {
	    Cloth cloth = new Cloth("T-shirt 1","2016-10-12",10.00,true);
	    Type type1 = new Type("t-shirt");
//        Wearer wearer = new Wearer("Jan",1990);
//        cloth.getWearers().add(wearer);
        cloth.setType(type1);
	    clothesManager.addCloth(cloth);

        cloth = new Cloth("Hoodie 1","2016-10-13",20.00,true);
        Type type2 = new Type("hoodie");
        cloth.setType(type2);
        clothesManager.addCloth(cloth);
    }

    @Test
    public void deleteClothCheck(){
	    Long id = (long) 1;
	    Cloth retrievedCloth = clothesManager.findClothById(id);
        System.out.println("\n==== Usuwam ====");
            System.out.println(retrievedCloth.toString());

	    if(retrievedCloth == null){
            System.out.println("Nie znaleziono ubrania z id:"+id);
            return;
        } else{
            clothesManager.deleteCloth(retrievedCloth);
            System.out.println("Usunieto ubranie z id:"+id);
        }
    }

    @Test
    public void getAllClothesCheck(){
	    List<Cloth> clothes = clothesManager.getAllClothes();
        System.out.println("\n==== Lista ubrań ====");
	    for(Cloth c : clothes){
            System.out.println(c.toString());
        }
    }

    @Test
    public void getClothById(){
        List<Cloth> clothes = clothesManager.getAllClothes();
        System.out.println("\n==== Lista ubrań ====");
        for(Cloth c : clothes){
            System.out.println(c.toString());
        }
    }
}
