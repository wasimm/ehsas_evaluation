package edu.aku.wasimabbas.ehsas_evaluation.ui.other;

public class MWRAs {

    private final long id;
    private final int serial;
    private final String name;
    private final String uid;
    private final String age;

    public MWRAs(long id, int serial, String name, String uid, String age) {
        this.id = id;
        this.serial = serial;
        this.name = name;
        this.uid = uid;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public int getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getAge() {
        return age;
    }
}
