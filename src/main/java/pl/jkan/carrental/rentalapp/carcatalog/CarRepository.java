package pl.jkan.carrental.rentalapp.carcatalog;


import org.springframework.data.repository.CrudRepository;

interface CarRepository extends CrudRepository<Car, String> {
}
