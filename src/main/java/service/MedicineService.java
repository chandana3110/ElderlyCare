package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Medicine;
import repository.MedicineRepository;

import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    
//    static {
//    	new Medicine("dolo", "1 pill", LocalDateTime.now());
//    	new Medicine("combiflam", "1 pill", LocalDateTime.now());
//    }
    
    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }
    
    public void updateMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return (List<Medicine>) medicineRepository.findAll();
    }
    
    public Medicine getMedicine(Integer id) {
        return medicineRepository.findById(new Long(id)).get();
    }
}
