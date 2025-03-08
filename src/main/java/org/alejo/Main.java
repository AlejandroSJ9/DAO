package org.alejo;

import org.alejo.model.Order;
import org.alejo.model.Product;
import org.alejo.model.User;
import org.alejo.repository.OrderRepository;
import org.alejo.repository.ProductRepository;
import org.alejo.repository.UserRepository;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static final UserRepository userDAO = new UserRepository();
    private static final ProductRepository productDAO = new ProductRepository();
    private static final OrderRepository orderDAO = new OrderRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Listar Usuarios");
            System.out.println("3. Crear Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Crear Orden");
            System.out.println("6. Listar Órdenes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> listarUsuarios();
                case 3 -> crearProducto();
                case 4 -> listarProductos();
                case 5 -> crearOrden();
                case 6 -> listarOrdenes();
                case 7 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    private static void crearUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        User usuario = new User(nombre, email);
        userDAO.save(usuario);
        System.out.println("Usuario creado exitosamente.");
    }

    private static void listarUsuarios() {
        List<User> usuarios = userDAO.getAll();
        System.out.println(usuarios);
        System.out.println("\n--- Lista de Usuarios ---");
        for (User u : usuarios) {
            System.out.println("ID: " + u.getId() + ", Nombre: " + u.getName() + ", Email: " + u.getEmail());
        }
    }

    private static void crearProducto() {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese stock: ");
        int stock = scanner.nextInt();

        Product producto = new Product(null, nombre, precio, stock);
        productDAO.save(producto);
        System.out.println("Producto creado exitosamente.");
    }

    private static void listarProductos() {
        List<Product> productos = productDAO.getAll();
        System.out.println("\n--- Lista de Productos ---");
        for (Product p : productos) {
            System.out.println("ID: " + p.getId() + ", Nombre: " + p.getName() + ", Precio: $" + p.getPrice() + ", Stock: " + p.getStock());
        }
    }

    private static void crearOrden() {
        System.out.print("Ingrese ID del usuario: ");
        Integer userId = scanner.nextInt();
        System.out.print("Ingrese ID del producto: ");
        Integer productId = scanner.nextInt();
        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();

        Order orden = new Order(null, userId, productId, cantidad, null);
        orderDAO.save(orden);
        System.out.println("Orden creada exitosamente.");
    }

    private static void listarOrdenes() {
        List<Order> ordenes = orderDAO.getAll();
        System.out.println("\n--- Lista de Órdenes ---");
        for (Order o : ordenes) {
            System.out.println("ID: " + o.getId() + ", Usuario ID: " + o.getUserId() + ", Producto ID: " + o.getProductId() + ", Cantidad: " + o.getQuantity() + ", Fecha: " + o.getOrderDate());
        }
    }
}