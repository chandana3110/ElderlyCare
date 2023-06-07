package Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Medicine;
import service.MedicineService;
import service.ReminderService;

@RestController
public class MedicineReminderController {
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
    private ReminderService reminderService;
	
	@GetMapping(value = "/reminders")
    public List<Medicine> getAllReminders() {
        return medicineService.getAllMedicines();
    }
	
	@GetMapping(value = "/reminders/{id}")
    public Medicine getReminder(@PathVariable("id") Integer id) {
        return medicineService.getMedicine(id);
    }
	
	@PostMapping(value = "/reminders")
    public String setReminder(Medicine medicine) {
        return "welcome";
    }
	
	@PostMapping(value = "/reminders/{id}")
    public String updateReminder(Medicine medicine) {
        return "welcome";
    }
	
}
