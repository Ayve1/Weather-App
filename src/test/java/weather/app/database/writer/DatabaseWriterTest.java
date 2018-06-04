package weather.app.database.writer;

import weather.app.config.SpringConfig;
import weather.app.database.entity.Measurement;
import weather.app.database.utilities.Component;
import weather.app.database.utilities.District;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static weather.app.config.ComponentNamesConfig.WRITER_COMPONENT_NAME;

/**
 * @author Wojciech Sankowski
 *
 * tests saving measurement objects to database
 */
public class DatabaseWriterTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IWriter writer = context.getBean(WRITER_COMPONENT_NAME, IWriter.class);

        try {
            //saving single measurement
            Measurement measurement = new Measurement(Component.C6H6, District.MAZOWIECKIE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-15 22:00:00"), 22.2);
            writer.save(measurement);

            System.out.println("Trying to save null...");
            //trying to save null
            measurement = null;
            writer.save(measurement);

            //checking list of measurements
            List<Measurement> measurementList = new ArrayList<Measurement>();
            measurementList.add(new Measurement(Component.NO2, District.DOLNOSLASKIE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-16 12:00:00"), 997));
            measurementList.add(new Measurement(Component.PM10, District.KUJAWSKO, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-15 15:00:00"), 0.5444));
            measurementList.add(new Measurement(Component.SO2, District.ZACHODNIOPOMORSKIE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-19 11:00:00"), 1.23));
            measurementList.add(new Measurement(Component.PM25, District.LODZKIE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-22 10:00:00"), 44.32112));
            measurementList.add(new Measurement(Component.CO, District.LUBELSKIE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-08 9:00:00"), 89));
            writer.save(measurementList);
        } catch (ParseException e) {
            System.out.println("Error while creating date");
        }
    }
}
