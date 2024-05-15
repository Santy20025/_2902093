package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Empleado {
    private String nombres;
    private String apellidos;
    private String documento;
    private int diasTrabajados;
    private double salarioBasico;
    private double subsidioTransporte;

    public Empleado(String nombres, String apellidos, String documento, int diasTrabajados, double salarioBasico, double subsidioTransporte) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.salarioBasico = salarioBasico;
        this.subsidioTransporte = subsidioTransporte;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public double getSubsidioTransporte() {
        return subsidioTransporte;
    }

    public double calcularTotalDevengos() {
        return (salarioBasico * diasTrabajados) + subsidioTransporte;
    }

    public double calcularTotalDescuentos() {

        return salarioBasico * 0.1;
    }

    public double calcularSalarioNeto() {
        return calcularTotalDevengos() - calcularTotalDescuentos();
    }
}

public class LiquidacionNomina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("Ingrese los datos del empleado " + (i + 1) + ":");
            System.out.print("Nombres: ");
            String nombres = scanner.next();
            System.out.print("Apellidos: ");
            String apellidos = scanner.next();
            System.out.print("Documento: ");
            String documento = scanner.next();
            System.out.print("Días trabajados: ");
            int diasTrabajados = scanner.nextInt();
            System.out.print("Salario básico: ");
            double salarioBasico = scanner.nextDouble();
            System.out.print("Subsidio de transporte (si corresponde): ");
            double subsidioTransporte = scanner.nextDouble();

            empleados.add(new Empleado(nombres, apellidos, documento, diasTrabajados, salarioBasico, subsidioTransporte));
        }

        System.out.println("\nLiquidación de nómina:");

        for (Empleado empleado : empleados) {
            System.out.println("\nEmpleado: " + empleado.getNombres() + " " + empleado.getApellidos());
            System.out.println("Total devengos: " + empleado.calcularTotalDevengos());
            System.out.println("Total descuentos: " + empleado.calcularTotalDescuentos());
            System.out.println("Salario neto a pagar: " + empleado.calcularSalarioNeto());
        }

        scanner.close();
    }
}
