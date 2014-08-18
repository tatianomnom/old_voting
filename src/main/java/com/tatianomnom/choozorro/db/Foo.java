package com.tatianomnom.choozorro.db;

/**
 * TODO add description
 */
public class Foo {

    private final int id;
    private final String name;

    public Foo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //for MyBatis. looks too bad, maybe omit 'final' and leave empty default constructor?
    private Foo() {
        id = 0;
        name = "";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foo foo = (Foo) o;

        return id == foo.id && name.equals(foo.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
