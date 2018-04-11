package Tours;

/**
 *
 * @author Disha
 */

class NameException extends Exception
{
    @Override
    public String toString()
    {
        return "Invalid name";
    }
}

class AgeException extends Exception
{
    @Override
    public String toString()
    {
        return "Sorry. We only cater to customers between 18 years and 80 years of age";
    }
}

class PhoneException extends Exception
{
    @Override
    public String toString()
    {
        return "Invalid phone number";
    }
}

class GenderException extends Exception
{
    @Override
    public String toString()
    {
        return "Please enter only M or F";
    }
}

public class Exceptions {
    
}
