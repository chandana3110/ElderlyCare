package service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {
    private final String twilioPhoneNumber;
    
    public static final String ACCOUNT_SID = "<ACCOUNT_SID>";  
    public static final String AUTH_TOKEN = "<AUTH_TOKEN>";

    public ReminderService(@Value("${twilio.phone.number}") String twilioPhoneNumber) {
        this.twilioPhoneNumber = twilioPhoneNumber;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendReminder(String recipientPhoneNumber, String reminderMessage, LocalDateTime reminderTime) {
        Message message = Message.creator(
                new PhoneNumber(recipientPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                "Please remember to take your medicine: " + reminderMessage
        ).create();

        System.out.println("SMS reminder sent: " + message.getSid());
    }
}



