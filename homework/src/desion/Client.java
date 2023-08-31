package desion;


public class Client
{
    public static void main(String args[])
    {
        try
        {
           Person person;
            String PeopleName=XMLUtilPeople.getPeopleName();
            person= Nvwa.makePerson(PeopleName);
            person.make();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}