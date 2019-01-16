package pl.spiascik.ug.app.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.spiascik.ug.app.domain.Cloth;

@Component
@Transactional
public class ClothesMangerHibernateImpl implements ClothesManager {

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
        sessionFactory.getCurrentSession().persist(cloth);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cloth> getAllClothes() {
        return sessionFactory.getCurrentSession().getNamedQuery("cloth.all").list();
    }

    @Override
    public List<Cloth> getWaterproofClothes() {
        return sessionFactory.getCurrentSession().getNamedQuery("cloth.waterproof")
                .list();
    }

    @Override
    public void deleteCloth(Cloth cloth) {
        sessionFactory.getCurrentSession().delete(cloth);
    }

    @Override
    public Cloth findClothById(Long id) {
	    return (Cloth) sessionFactory.getCurrentSession().getNamedQuery("cloth.byId").setInteger("id",id.intValue()).uniqueResult();
    }

}
