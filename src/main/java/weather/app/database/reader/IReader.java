package weather.app.database.reader;

import weather.app.database.entity.Measurement;
import weather.app.database.utilities.District;

import java.util.Date;
import java.util.List;

/**
 * @author Wojciech Sankowski
 */
public interface IReader {
    /**
     * enables to fetch list of {@link Measurement} beginning from one date to another date
     * useful while creating statistics reports
     * @param district specific id of {@link District}
     * @param fromDate beginning date
     * @param toDate ending date
     * @return list of {@link Measurement} objects
     */
    List<Measurement> fetchMeasurementsWithDateRange(final District district, final Date fromDate, final Date toDate);

    /**
     * enables to fetch single {@link Measurement} with specific date
     * useful while checking if specific {@link Measurement} with given date already exists in app.database
     * @param district specific id of {@link District}
     * @param date date of {@link Measurement}
     * @return {@link Measurement} object or null if {@link Measurement} not found in app.database
     */
    Measurement fetchMeasurementWithSpecificDate(final District district, final Date date);
}
