package Proyectos;
import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                                    break;
                                case 2:
                                    break;
                                case 3:
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
                                        break;
                                    case 2:
                                        break;
                                    case 3:
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
                                        break;
                                    case 2:
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
