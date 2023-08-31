package desion;

public class Nvwa {

    public static Person makePerson(String sex) throws Exception
    {
        if(sex.equalsIgnoreCase("M"))
        {
            System.out.println("Man");
            return new Man();
        }
        else if(sex.equalsIgnoreCase("W"))
        {
            System.out.println("Women");
            return new Man();
        }
        else if(sex.equalsIgnoreCase("R"))
        {
            System.out.println("Man");
            return new Women();
        }
        else
        {
            throw new Exception("不能生产此类人");
        }
    }


}
