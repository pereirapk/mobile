package com.example.ggp.mobilefinal;

public class Nota {
    private int id;
    private float nota;
    private String curso;

    public Nota(){}

    public Nota(int id, float nota, String curso) {
        this.id = id;
        this.nota = nota;
        this.curso = curso;
    }

    public Nota(float nota, String curso) {
        this.nota = nota;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
