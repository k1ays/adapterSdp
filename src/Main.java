// Target (новый интерфейс, который мы хотим использовать)
interface Charger {
    void charge();
}

// Adaptee (существующий несовместимый класс)
class OldSocket {
    public int getVoltage() {
        return 220; // розетка выдаёт 220В
    }
}

// Adapter (делает 220В → 5В)
class SocketAdapter implements Charger {
    private OldSocket socket;

    public SocketAdapter(OldSocket socket) {
        this.socket = socket;
    }

    @Override
    public void charge() {
        int volts = socket.getVoltage();
        int converted = 5; // представим, что преобразовали
        System.out.println("Адаптер преобразовал " + volts + "V в " + converted + "V. Заряжаем телефон!");
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        Charger charger = new SocketAdapter(new OldSocket());
        charger.charge();
    }
}
