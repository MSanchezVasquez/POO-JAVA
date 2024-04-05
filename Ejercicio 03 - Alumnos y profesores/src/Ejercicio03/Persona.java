package Ejercicio03;

public abstract class Persona {
    private String nombre;
    private char sexo;
    private int edad;

    //Constantes
    private final String[] NOMBRES_CHICOS = {"Pepe", "Fernando", "Alberto", "Nacho", "Mike"};
    private final String[] NOMBRES_CHICAS = {"Pepa", "Alicia", "Clotilde", "Nacha", "Mikaela"};
    private final int CHICO = 0;
    private final int CHICA = 0;
    private boolean asistencia;

    public Persona() {
        int determinar_sexo = MetodosSueltos.generaNumeroAleatorio(0, 1);
        //Si es 0 es un chico
        if (determinar_sexo == 0) {
            nombre = NOMBRES_CHICOS[MetodosSueltos.generaNumeroAleatorio(0, 4)];
            sexo = 'H';
        } else {
            nombre = NOMBRES_CHICAS[MetodosSueltos.generaNumeroAleatorio(0, 4)];
            sexo = 'M';
        }
        disponibilidad();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
    
    public abstract void disponibilidad();
}
