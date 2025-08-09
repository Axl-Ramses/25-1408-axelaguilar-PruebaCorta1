import java.util.ArrayList;
package com.gestor.tareas;

public class GestorTareas {
 private ArrayList<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada.");
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println("Tarea #" + (i + 1));
            tareas.get(i).mostrarInfo();
        }
    }

    public void listarTareasPorEstado(boolean completadas) {
        boolean hay = false;
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).isCompletada() == completadas) {
                System.out.println("Tarea #" + (i + 1));
                tareas.get(i).mostrarInfo();
                hay = true;
            }
        }
        if (!hay) {
            System.out.println(completadas ? "No hay tareas completadas." : "No hay tareas pendientes.");
        }
    }

    public void marcarTareaComoCompletada(int index) {
        if (index < 0 || index >= tareas.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        tareas.get(index).marcarComoCompletada();
        System.out.println("Tarea marcada como completada.");
    }

    public void editarTarea(int index, String descripcion, String fechaLimite, String prioridad, String categoria) {
        if (index < 0 || index >= tareas.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        tareas.get(index).editarTarea(descripcion, fechaLimite, prioridad, categoria);
        System.out.println("Tarea editada.");
    }

    public void eliminarTarea(int index) {
        if ((index < 0) || (index >= tareas.size())) {
            System.out.println("Indice invalido.");
            return;
        }
        tareas.remove(index);
        System.out.println("Tarea eliminada.");
    }
}
