package repository;
import org.springframework.data.repository.CrudRepository;

import model.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
}
