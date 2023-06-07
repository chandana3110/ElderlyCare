package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import model.Medicine;
import service.MedicineService;
import service.ReminderService;

import java.util.List;

@Component
public class ReminderScheduler {
    private final MedicineService medicineService;
    private final ReminderService reminderService;

    @Autowired
    public ReminderScheduler(MedicineService medicineService, ReminderService reminderService) {
        this.medicineService = medicineService;
        this.reminderService = reminderService;
    }

    @Scheduled(cron = "${reminder.task.cron}")
    public void sendReminders() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        for (Medicine medicine : medicines) {
            reminderService.sendReminder("<elderly phone number>", medicine.getName() + " - " + medicine.getDosage(), medicine.getStartDate());
        }
    }
}
