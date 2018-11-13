public class Runner {
    public static void main(String[] args)
    {
        TokenPass t = new TokenPass(4);
        t.print();
        t.distributePlayerTokens();
        t.print();
    }
}
