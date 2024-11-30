package shpp.azaika;

public enum NumberType{
    BYTE(Byte.class),
    SHORT(Short.class),
    INT(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class);
    private final Class<? extends Number> typeClass;
    NumberType(Class<? extends Number> typeClass) {
        this.typeClass = typeClass;
    }
    public Class<? extends Number> getTypeClass() {
        return typeClass;
    }
}
