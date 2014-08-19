package com.tatianomnom.choozorro.db;

/**
 * TODO add description
 */
public class Foo {

    private int id;
    private String name;

    public Foo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //for MyBatis
    private Foo() {
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
