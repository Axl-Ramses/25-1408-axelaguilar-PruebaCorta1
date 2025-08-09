import com.gestor.tareas.GestorTareas;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENU:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar todas");
            System.out.println("3. Marcar completada");
            System.out.println("4. Editar tarea");
            System.out.println("5. Listar pendientes");
            System.out.println("6. Listar completadas");
            System.out.println("7. Eliminar tarea");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Descripcion: ");
                    String desc = sc.nextLine();
                    System.out.print("Fecha limite: ");
                    String fecha = sc.nextLine();
                    System.out.print("Prioridad (Alta/Media/Baja): ");
                    String prioridad = sc.nextLine();
                    System.out.print("Categoria (Trabajo/Estudio/Personal/Otro): ");
                    String categoria = sc.nextLine();
                    gestor.agregarTarea(new Tarea(desc, fecha, prioridad, categoria));
                    break;

                case "2":
                    gestor.listarTareas();
                    break;

                case "3":
                    System.out.print("Numero de tarea para marcar completada: ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        gestor.marcarTareaComoCompletada(idx);
                    } catch (Exception e) {
                        System.out.println("Entrada invalida.");
                    }
                    break;

                case "4":
                    System.out.print("Numero de tarea a editar: ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("Nueva descripcion: ");
                        String d = sc.nextLine();
                        System.out.print("Nueva fecha limite: ");
                        String f = sc.nextLine();
                        System.out.print("Nueva prioridad: ");
                        String p = sc.nextLine();
                        System.out.print("Nueva categoria: ");
                        String c = sc.nextLine();
                        gestor.editarTarea(idx, d, f, p, c);
                    } catch (Exception e) {
                        System.out.println("Entrada invalida.");
                    }
                    break;

                case "5":
                    gestor.listarTareasPorEstado(false);
                    break;

                case "6":
                    gestor.listarTareasPorEstado(true);
                    break;

                case "7":
                    System.out.print("Numero de tarea a eliminar: ");
                    try {
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        gestor.eliminarTarea(idx);
                    } catch (Exception e) {
                        System.out.println("Entrada invalida.");
                    }
                    break;

                case "8":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();

    }
}