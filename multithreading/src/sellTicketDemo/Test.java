package sellTicketDemo;

public class Test {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        Thread window1 = new Thread(ticket, "窗口1");
        Thread window2 = new Thread(ticket, "窗口2");
        Thread window3 = new Thread(ticket, "窗口3");

        window1.start();
        window2.start();
        window3.start();

    }
}
