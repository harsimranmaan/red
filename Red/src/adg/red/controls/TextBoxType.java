package adg.red.controls;

/**
 *
 * @author harsimran.maan
 */
public enum TextBoxType
{

    Numeric("[0-9]+"),
    Decimal("[0-9]*.[0-9]{2}"),
    Alpha("[A-Za-z ]+"),
    Email("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}"),
    PostalCode("\\w{6,7}"),
    Phone("[0-9]{10}"),
    AplhaNumeric(""), Any(".*");
    private final String pattern;

    private TextBoxType(String pattern)
    {
        this.pattern = pattern;
    }

    /**
     * Get layout X position
     * <p/>
     * @return
     */
    public String getPattern()
    {
        return pattern;
    }
}
