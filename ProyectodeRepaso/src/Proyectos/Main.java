package Proyectos;
import org.w3c.dom.ls.LSOutput;

import java.lang.Math;
import java.util.*;
import java.text.*;
import java.time.*;
public class Main {
    //variables y arreglos
    // para citas
    private static LocalTime[] horas = new LocalTime[11];
    private static String[] estado = new String[11];
    private static LocalDate[] fechas = new LocalDate[11];
    private static String[] nombre = new String[11];
    private static String[] nombreMascota = new String[11];
    private static int cont = 0;
    // para diagnosticos
    private static String[] nombreDiagnostico = new String[11];
    private static String[] nombreMascotaDagnostico = new String[11];
    private static String[] diagnostico = new String[11];
    private static Scanner sc = new Scanner(System.in);
    private static int cont2 = 0;
    //otros
    private static String positivo = "S";
    private static String negativo = "N";
//metodos

    public static LocalDate pedirFecha() {
        System.out.println("Introduzca la fecha con formato aaaa-mm-dd");
        Scanner sc = new Scanner(System.in);
        String ingresarFecha;
        LocalDate fecha = null;
        boolean salir = false;
        while (!salir){
            try{
                ingresarFecha = sc.nextLine();
                fecha = LocalDate.parse(ingresarFecha);
                salir = true;
            } catch (Exception ex)
            {
                System.out.println("Porfavor ingrese un formato valido");
            }
        }

        return fecha;

    }
    public static LocalTime pedirHora(){
        System.out.println("Ingrese la hora a la que asistira a la cita en formato de 24 horas (hh:mm).");
        Scanner sc = new Scanner(System.in);
        String ingresarHora;
        LocalTime hora = null;
        boolean salir = false;
        while(!salir){
            try{
                ingresarHora = sc.nextLine();
                hora = LocalTime.parse(ingresarHora);
                salir = true;
            }catch(Exception ex){
                System.out.println("El formato de la hora ingresada es incorrecto, porfavor ingrese una hora valida");
            }
        }
            
        return hora;
    }

    public static String diagnostico(){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.println("Ingrese el diagnostico");
        String cadena = sc.nextLine();

        return cadena;
    }

// menu de citas
    public static void agendarCita()
    {
        cont++;
        if (cont > 9) {
            System.out.println("Ya no hay cupo para mas citas");

        }else {
            estado[cont] = "Activa";
            fechas[cont] = pedirFecha();
            horas[cont] = pedirHora();
            System.out.println("Ingrese el nombre del cliente");
            nombre[cont] = sc.next();
            System.out.println("Ingrese el nombre de la mascota del cliente");
            nombreMascota[cont] = sc.next();
        }
        System.out.println("Cita agendada para " + fechas[cont] +" a las "+horas[cont]);
        System.out.println("Su numero de cita es: " + cont);
    }

    public static void reagendarCita()
    {
        System.out.println("Por favor introduzca el numero de cita");
        int numCita = sc.nextInt();
        System.out.println("La cita escogida presenta los siguientes datos:");
        System.out.println("Fecha: "+ fechas[numCita]);
        System.out.println("Hora: "+ horas[numCita]);
        System.out.println("Nombre cliente: "+nombre[numCita]);
        System.out.println("Nombre mascota: "+nombreMascota[numCita]);

        System.out.println("¿Desea reagendar esta cita?(S/N)");
        int x = 0;
        while(x == 0){
            String confirmacion = sc.next();
            if(confirmacion.equals(positivo)){
                fechas[numCita] = pedirFecha();
                horas[numCita] = pedirHora();
                System.out.println("----------------------------------");
                System.out.println("Su cita se ha reagendado");
                System.out.println("----------------------------------");
                x = 1;
            }else{
                if (confirmacion.equals(negativo)){
                    System.out.println("----------------------------------");
                    System.out.println("Su cita no sera reagendada");
                    System.out.println("----------------------------------");
                    x = 1;
                }else{
                    System.out.println("Ingrese un valor valido");
                }
            }
        }

    }

    public static void cancelarCita()
    {
        System.out.println("Por favor introduzca el numero de cita que desea cancelar");
        int numCita = sc.nextInt();
        System.out.println("La cita escogida presenta los siguientes datos:");
        System.out.println("Fecha: "+ fechas[numCita]);
        System.out.println("Hora: "+ horas[numCita]);
        System.out.println("Nombre cliente: "+nombre[numCita]);
        System.out.println("Nombre mascota: "+nombreMascota[numCita]);
        System.out.println("¿Desea cancelar esta cita?(S/N)");
        int x = 0;
        while (x == 0){
            String confirmacion = sc.next();
            if (confirmacion.equals(positivo)){
                estado[numCita] = "Cancelado";
                System.out.println("----------------------------------");
                System.out.println("Su cita ha sido cancelada.");
                System.out.println("----------------------------------");
                x = 1;
            }else{
                if (confirmacion.equals(negativo))
                {
                    System.out.println("----------------------------------");
                    System.out.println("Su cita no sera cancelada");
                    System.out.println("----------------------------------");
                    x = 1;
                } else{
                    System.out.println("Ingrese un valor valido");
                }
            }
        }

    }


    //menu de diagnosticos
    public static void registrarDiagnostico()
    {
        cont2++;
            System.out.println("Ingrese el nombre del cliente.");
            nombreDiagnostico[cont2] = sc.next();
            System.out.println("Ingrese el nombre de la mascota del cliente.");
            nombreMascotaDagnostico[cont2] = sc.next();
            diagnostico[cont2] = diagnostico();
            System.out.println("");
            System.out.println("Diagnostico registrado con el numero: " + cont2);
    }

    public static void modificarDiagnostico() {
        System.out.println("Ingrese el numero del diagnostico que desea modificar");
        int numDiag = sc.nextInt();
        System.out.println("El numero de diagnostico corresponde a :");
        System.out.println("Cliente: " + nombreDiagnostico[numDiag]);
        System.out.println("Mascota: " + nombreMascotaDagnostico[numDiag]);
        System.out.println("Con el siguiente diagnostico: " + diagnostico[numDiag]);
        System.out.println("¿Desea cambiar este diagnostico?(S/N)");
        int x = 0;
        while (x == 0) {
            String confirmacion = sc.next();
            if (confirmacion.equals(positivo)) {
                diagnostico[numDiag] = diagnostico();
                System.out.println("----------------------------------");
                System.out.println("El diagnostico ha sido modificado");
                System.out.println("----------------------------------");
                x = 1;
            } else {
                if (confirmacion.equals(negativo)) {
                    System.out.println("----------------------------------");
                    System.out.println("El diagnóstico no sera cambiado");
                    System.out.println("----------------------------------");
                    x = 1;
                } else {
                    System.out.println("Ingrese un valor valido");
                }
            }
        }
    }

    public static void eliminarDiagnostico()
    {
        System.out.println("Ingrese el numero del diagnostico que desea eliminar");
        int numDiag = sc.nextInt();
        System.out.println("El numero de diagnostico corresponde a:");
        System.out.println("Cliente: " + nombreDiagnostico[numDiag]);
        System.out.println("Mascota: "+ nombreMascotaDagnostico[numDiag]);
        System.out.println("Con el siguiente diagnostico: " + diagnostico[numDiag]);
        System.out.println("¿Desea eliminar este diagnostico?(S/N)");
        String confirmacion = sc.next();
        if (confirmacion.equals(positivo)){
            diagnostico[numDiag] = "No existe diagnostico";
            System.out.println("----------------------------------");
            System.out.println("El diagnostico ha sido eliminado.");
            System.out.println("----------------------------------");
        }else{
            if (confirmacion.equals(negativo))
            {
                System.out.println("----------------------------------");
                System.out.println("El diagnostico no sera eliminado");
                System.out.println("----------------------------------");
            }else{
                System.out.println("Ingrese un valor valido");
            }
        }


    }

    // menu de reportes
    public static void mostrarCitas()
    {
        for (int i = 1; i < (cont + 1); i++)
        {
            System.out.println("____________________________________________");
            System.out.println("Cita numero " + i);
            System.out.println("Fecha: "+ fechas[i]);
            System.out.println("Hora: "+ horas[i]);
            System.out.println("Nombre del cliente: " + nombre[i]);
            System.out.println("Nombre de la mascota: "+ nombreMascota[i]);
            System.out.println("Estado de la cita: "+ estado[i]);
            System.out.println("____________________________________________");
            System.out.println("");
        }
    }

    public static void mostrarDiagnosticos()
    {
        for (int i = 1; i < (cont2 + 1); i++)
        {
            System.out.println("____________________________________________");
            System.out.println("Numero de diagnostico: "+i);
            System.out.println("Nombre del cliente: " + nombreDiagnostico[i]);
            System.out.println("Nombre de la mascota: " + nombreMascotaDagnostico[i]);
            System.out.println("Diagnostico: " + diagnostico[i]);
            System.out.println("____________________________________________");
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        boolean salir = false;
        while(!salir) {
            System.out.println("           Veterinaria Laux");
            System.out.println("****************************************");
            System.out.println("1. Citas");
            System.out.println("2. Diagnosticos");
            System.out.println("3. Reportes");
            System.out.println("4. Salir");
            System.out.println("****************************************");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        boolean salir2 = false;
                        while (!salir2)
                        {
                        System.out.println("           Menu de citas");
                        System.out.println("****************************************");
                        System.out.println("1. Agendar Cita");
                        System.out.println("2. Re-agendar cita");
                        System.out.println("3. Cancelar cita");
                        System.out.println("4. Menú principal");
                        System.out.println("****************************************");
                        try {
                            int opcion1 = sc.nextInt();
                            switch (opcion1) {
                                case 1:
                                agendarCita();
                                break;
                                case 2:
                                    reagendarCita();
                                    break;
                                case 3:
                                    cancelarCita();
                                    break;
                                case 4:
                                    salir2 = true;
                                    break;
                                default:
                                    System.out.println("Ingrese un numero valido");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese un numero valido");
                            sc.next();
                        }
                }
                        break;
                    case 2:
                        boolean salir3 = false;
                        while (!salir3)
                        {
                            System.out.println("           Menu de diagnosticos");
                            System.out.println("****************************************");
                            System.out.println("1. Registrar diagnostico");
                            System.out.println("2. Modificar diagnostico");
                            System.out.println("3. Eliminar diagnostico");
                            System.out.println("4. Menú principal");
                            System.out.println("****************************************");
                            try {
                                int opcion2 = sc.nextInt();
                                switch (opcion2) {
                                    case 1:
                                    registrarDiagnostico();
                                        break;
                                    case 2:
                                        modificarDiagnostico();
                                        break;
                                    case 3:
                                        eliminarDiagnostico();
                                        break;
                                    case 4:
                                        salir3 = true;
                                        break;
                                    default:
                                        System.out.println("Ingrese un numero valido");
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ingrese un numero valido");
                                sc.next();
                            }
                        }
                        break;
                    case 3:
                        boolean salir4 = false;
                        while (!salir4) {
                            System.out.println("           Menu de reportes");
                            System.out.println("****************************************");
                            System.out.println("1. Reporte de citas");
                            System.out.println("2. Reporte de diagnosticos");
                            System.out.println("3. Menu principal");
                            System.out.println("****************************************");
                            try {
                                int opcion3 = sc.nextInt();
                                switch (opcion3) {
                                    case 1:
                                        mostrarCitas();
                                        break;
                                    case 2:
                                        mostrarDiagnosticos();
                                        break;
                                    case 3:
                                        salir4 = true;
                                        break;
                                    default:
                                        System.out.println("Ingrese un numero valido");
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ingrese un numero valido");
                                sc.next();
                            }
                        }
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        break;

                }
            }catch(InputMismatchException e)
            {
                System.out.println("Ingrese un numero valido");
                sc.next();

            }
        }


    }
}
