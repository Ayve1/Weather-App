package weather.app.database.reader;

import weather.app.config.SpringConfig;
import weather.app.database.entity.Measurement;
import weather.app.database.utilities.District;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static weather.app.config.ComponentNamesConfig.READER_COMPONENT_NAME;

/**
 * @author Wojciech Sankowski
 *
 * tests fetching {@link Measurement} objects from database
 */
public class ReaderTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IReader reader = context.getBean(READER_COMPONENT_NAME, IReader.class);
        District district = District.MAZOWIECKIE;
        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-11-15 12:00:00");
            toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-15 22:00:00");
        } catch (ParseException e) {
            System.out.println("Error while creating date");
        }

        //fetching single Measurement
        System.out.println("Fetching single measurement...");
        System.out.println(reader.fetchMeasurementWithSpecificDate(district, toDate));

        //fetching list of Measurement objects
        System.out.println("\n\nFetching list of measurements...");
        List<Measurement> measurementList = reader.fetchMeasurementsWithDateRange(district, fromDate, toDate);
        System.out.println(measurementList);

        try {
            fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2217-11-15 12:00:00");
            toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2317-11-15 22:00:00");
        } catch (ParseException e) {
            System.out.println("Error while creating date");
        }

        //fetching single Measurement
        System.out.println("Fetching single measurement...");
        Measurement measurement = reader.fetchMeasurementWithSpecificDate(district, fromDate);
        if (measurement == null) {
            System.out.println("Date: " + fromDate + "\nNothing found");
        } else {
            System.out.println(measurement);
        }

        //fetching list of Measurement objects
        System.out.println("\n\nFetching list of measurements...");
        measurementList = reader.fetchMeasurementsWithDateRange(district, fromDate, toDate);
        if (measurementList == null || measurementList.isEmpty()) {
            System.out.println("Date: " + fromDate + " to " + toDate + " nothing found");
        } else {
            System.out.println(measurementList);
        }
    }
}
