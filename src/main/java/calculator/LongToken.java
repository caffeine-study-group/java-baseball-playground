package calculator;

public class LongToken implements Token {
    long value;
    public LongToken(String value) {
        this.value = Long.parseLong(value);
    }

    @Override
    public Long getValue() {
        return this.value;
    }
}
