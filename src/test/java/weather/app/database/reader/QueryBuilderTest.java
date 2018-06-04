package weather.app.database.reader;

import weather.app.database.utilities.District;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Wojciech Sankowski
 *
 * tests if queries are build correctly
 */
public class QueryBuilderTest {

    private final Date fromDate;
    private final Date toDate;
    private final District district;
    private final QueryBuilder queryBuilder;

    /**
     * example of query with single date
     */
    private final String QUERY_WITH_SINGLE_DATE = "FROM Measurement WHERE datetime = '2017-11-08 09:30:14' AND district_id = 'kujawsko'";

    /**
     * example of query with date range
     */
    private final String QUERY_WITH_DATE_RANGE = "FROM Measurement WHERE district_id = 'kujawsko' AND datetime BETWEEN '2017-11-08 09:30:14' AND '2022-05-21 21:21:21'";

    public QueryBuilderTest() throws ParseException {
        fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-11-08 09:30:14");
        toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-21 21:21:21");
        district = District.KUJAWSKO;
        queryBuilder = new QueryBuilder();
    }

    @Test
    public void shouldBeEqualToQueryWithSingleDate() {
        String query = queryBuilder.buildQueryWithSingleDate(fromDate, district);
        assertEquals(query, QUERY_WITH_SINGLE_DATE);
    }

    @Test
    public void shouldBeEqualToQueryWithDateRange() {
        String query = queryBuilder.buildQueryWithDateRange(fromDate, toDate, district);
        assertEquals(query, QUERY_WITH_DATE_RANGE);
    }

}