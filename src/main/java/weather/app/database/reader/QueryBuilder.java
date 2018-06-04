package weather.app.database.reader;

import weather.app.database.utilities.District;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

import static weather.app.database.utilities.MeasurementNamingConfig.DATETIME_COLUMN;
import static weather.app.database.utilities.MeasurementNamingConfig.DISTRICT_ID_COLUMN;

/**
 * @author Wojciech Sankowski
 *
 * class responsible for building specific queries
 */
@Component
class QueryBuilder {

    private final String AND = "AND";
    private final String FROM = "FROM";
    private final String WHERE = "WHERE";
    private final String BETWEEN = "BETWEEN";

    private final String TABLE_MAPPING_NAME = "Measurement";

    private String query;

    /**
     * query with specific date and district
     * @return String object representing query
     */
    String buildQueryWithSingleDate(final Date date, final District district) {
        startQuery();
        query += " " + WHERE + " ";

        //adding date to query in specific format
        //YYYY-MM-DD HH:mm:SS
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();
        query += DATETIME_COLUMN + " = '" + dateTimeFormat.format(date) + "'";

        query += " " + AND + " ";
        addDistrict(district);
        return query;
    }

    /**
     * query with specific date range and district
     * @return String object representing query
     */
    String buildQueryWithDateRange(final Date fromDate, final Date toDate, final District district) {
        startQuery();
        query += " " + WHERE + " ";
        addDistrict(district);
        query += " " + AND + " ";

        //adding date range to query in specific format
        //YYYY-MM-DD HH:mm:SS
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();
        query += DATETIME_COLUMN + " " + BETWEEN
                + " '" + dateTimeFormat.format(fromDate) + "' "
                + AND + " '" + dateTimeFormat.format(toDate)+ "'";

        return query;
    }

    private void startQuery() {
        query = FROM + " " + TABLE_MAPPING_NAME;
    }

    private void addDistrict(final District district) {
        query += DISTRICT_ID_COLUMN + " = '" + district.toString() + "'";
    }
}
