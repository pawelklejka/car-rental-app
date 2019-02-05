package pl.jkan.carrental.rental.cardao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jkan.carrental.rental.carmodel.Car;

import java.util.List;

public class CarRepoImplementation implements CarRepository {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public long save(Car car) {
        sessionFactory.getCurrentSession().save(car);
        return car.getId();
    }

    @Override
    public Car get(long id) {
        Car carWithId = sessionFactory.getCurrentSession()
                                .get(Car.class, id);

        return carWithId;
    }

    @Override
    public List<Car> list() {
        String query = "FROM Car";
        List carList = sessionFactory.getCurrentSession().
                            createQuery(query).
                            list();
        return carList;

    }

    @Override
    public void update(long id, Car car) {
        Session session = sessionFactory.getCurrentSession();
        Car oldCar = session.byId(Car.class).load(id);
        oldCar.setName(car.getName());
        oldCar.setModel(car.getModel());
        oldCar.setSegment(car.getSegment());
        oldCar.setCapacity(car.getCapacity());
        oldCar.setManufactureYear(car.getManufactureYear());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Car car = session.byId(Car.class).load(id);
        session.delete(car);
    }
}
