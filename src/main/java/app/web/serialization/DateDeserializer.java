package app.web.serialization;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateDeserializer {

    public Date parseDate(String dateOfBirth){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}