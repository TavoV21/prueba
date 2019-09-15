package com.ecodeup.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Libro;

public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Libro miLibro;

		EntityManager entity = JPAutil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			
			System.out.println("*****LIBRERIA*****");
			System.out.println("1. Crear Libro");
			System.out.println("2. Buscar Libro");
			System.out.println("3. Actualizar Libro");
			System.out.println("4. Eliminar Libro");
			System.out.println("5. Salir");
			System.out.println("******************");
			System.out.println("Elija una opción:");


			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Ingrese nombre del libro:");
				miLibro = new Libro();
				miLibro.setIdlibro(null);
				scanner.nextLine();
                miLibro.setLibro(scanner.nextLine());
                     		
				System.out.println("Ingrese el nombre del autor:");
				miLibro.setAutor(scanner.nextLine());
				
				System.out.println("Ingrese el numero de paginas:");
				miLibro.setPaginas(scanner.nextDouble());
				
				System.out.println("Ingrese el precio del libro:");
				miLibro.setPrecio(scanner.nextDouble());
				
				entity.getTransaction().begin();
				entity.persist(miLibro);
				entity.getTransaction().commit();
				
				System.out.println("Libro registrado exitosamente");
				System.out.println();
				break;

			case 2:
				System.out.println("Ingrese el id del Libro a buscar:");
				miLibro = new Libro();
				miLibro = entity.find(Libro.class, scanner.nextLong());
				if (miLibro != null) {
					System.out.println(miLibro);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("No se puedo encontrar libro");
					
					List<Libro> listaLibros= new ArrayList<>();
					
					Query query=entity.createQuery("SELECT l FROM Libro l");
					listaLibros=query.getResultList();
					for (Libro l : listaLibros) {
						System.out.println(l);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Ingrese el id del libro para actualizar:");
				miLibro = new Libro();

				miLibro = entity.find(Libro.class, scanner.nextLong());
				if (miLibro != null) {
					System.out.println(miLibro);
					System.out.println("Ingrese el nombre del libro:");
					scanner.nextLine();
	                miLibro.setLibro(scanner.nextLine());
					
					System.out.println("Ingrese el nombre del autor:");
					miLibro.setAutor(scanner.nextLine());
					
					System.out.println("Ingrese el numero de paginas:");
					miLibro.setPaginas(scanner.nextDouble());
					
					System.out.println("Ingrese el precio del libro:");
					miLibro.setPrecio(scanner.nextDouble());
					
										
					entity.getTransaction().begin();
					entity.merge(miLibro);
					entity.getTransaction().commit();
					
					System.out.println("Libro actualizado exitosamente");
					System.out.println();
				} else {
					System.out.println("No se pudo actualizar el libro");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del producto a eliminar:");
				miLibro = new Libro();

				miLibro = entity.find(Libro.class, scanner.nextLong());
				if (miLibro != null) {
					System.out.println(miLibro);
					
					entity.getTransaction().begin();
					entity.remove(miLibro);
					entity.getTransaction().commit();
					
					System.out.println("Libro eliminado con exito");
				} else {
					System.out.println("No se pudo eliminar el libro");
				}
				break;
			case 5:entity.close();JPAutil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}
