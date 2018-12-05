package pl.spiascik.ug.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.spiascik.ug.app.domain.Car;
import pl.spiascik.ug.app.domain.Person;
import pl.spiascik.ug.app.domain.Cloth;

@Component
@Transactional
public class SellingMangerHibernateImpl implements SellingManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



    @Override
    public void addCloth(Cloth cloth) {
        cloth.setId(null);
        sessionFactory.getCurrentSession().persist(cloth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cloth> getAllClothes() {
        return sessionFactory.getCurrentSession().getNamedQuery("cloth.all")
                .list();
    }

    @Override
    public void deleteCloth(Cloth cloth) {
        cloth = (Cloth) sessionFactory.getCurrentSession().get(Cloth.class,
                cloth.getId());

        sessionFactory.getCurrentSession().delete(cloth);
    }

    @Override
    public Cloth findClothById(Long id) {
        return (Cloth) sessionFactory.getCurrentSession().get(Cloth.class, id);
    }

}
