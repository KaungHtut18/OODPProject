public class hashtableCreator
{
    public static void main(String[] args)
    {
        String pw=BCrypt.hashpw("john123",BCrypt.gensalt());
        System.out.println(pw);
    }
}
