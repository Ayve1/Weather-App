package weather.app.database.reader;

import weather.app.database.connection.SessionManager;
import weather.app.database.entity.Measurement;
import weather.app.database.utilities.District;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static weather.app.config.ComponentNamesConfig.READER_COMPONENT_NAME;
import static weather.app.utilities.errorMessages.ReaderErrorMessages.COULD_NOT_READ_DATA;

/**
 * @author Wojciech Sankowski
 *
 * class responsible for fetching Measurement objects from database
 */
@Component(READER_COMPONENT_NAME)
public class Reader implements IReader {

    /**
     * database connector which manages session
     */
    private final SessionManager sessionManager;

    /**
     * query builder used to build specific queries
     */
    private final QueryBuilder queryBuilder;

    @Autowired
    public Reader(final SessionManager sessionManager, final QueryBuilder queryBuilder) {
        this.sessionManager = sessionManager;
        this.queryBuilder = queryBuilder;
    }

    /**
     * enables to fetch list of {@link Measurement} objects beginning from one date to another date
     * useful while creating statistics reports
     * @param district specific id of {@link District}
     * @param fromDate beginning date
     * @param toDate ending date
     * @return list of {@link Measurement} objects
     */
    public List<Measurement> fetchMeasurementsWithDateRange(final District district, final Date fromDate, final Date toDate) {
        String query = queryBuilder.buildQueryWithDateRange(fromDate, toDate, district);
        Session session = sessionManager.getSession();
        if (session == null) {
            System.out.println(COULD_NOT_READ_DATA);
            return null;
        }
        session.beginTransaction();
        List<Measurement> measurementList = session.createQuery(query).list();
        session.getTransaction().commit();
        sessionManager.closeSession();
        return measurementList;
    }

    /**
     * enables to fetch single {@link Measurement} with specific date
     * useful while checking if specific {@link Measurement} with given date already exists in database
     * @param district specific id of {@link District}
     * @param date date of {@link Measurement}
     * @return single {@link Measurement} or null if nothing found
     */
    public Measurement fetchMeasurementWithSpecificDate(final District district, final Date date) {
        String query = queryBuilder.buildQueryWithSingleDate(date, district);
        Session session = sessionManager.getSession();
        if (session == null) {
            System.out.println(COULD_NOT_READ_DATA);
            return null;
        }
        session.beginTransaction();
        List<Measurement> measurementList = session.createQuery(query).setFirstResult(0).setMaxResults(1).list();
        session.getTransaction().commit();
        sessionManager.closeSession();
        if (measurementList.isEmpty()) {
            return null;
        }
        return measurementList.get(0);
    }
}
