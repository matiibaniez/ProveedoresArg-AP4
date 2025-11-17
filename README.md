# ProveedoresArg – Prototipo AP4 (Java + MySQL)

Este repositorio contiene el **prototipo operacional desarrollado para el Trabajo Práctico AP4** del Seminario de Práctica Informática, correspondiente al proyecto **ProveedoresArg**, una plataforma destinada a conectar minoristas con proveedores mayoristas en Argentina.

El módulo implementado en esta entrega es **“Alta y Búsqueda de Proveedores”**, desarrollado en **Java**, utilizando **POO**, **MVC**, **JDBC**, **MySQL**, manejo de excepciones, arreglos y colecciones dinámicas.

---

## 🚀 Tecnologías Utilizadas
- Java 8 / 11 / 17  
- JDBC  
- MySQL 8  
- Patrón MVC  
- Programación Orientada a Objetos  
- ArrayList y Arreglos  
- Manejo de excepciones  

---

## 📁 Estructura del Proyecto

src/com/proveedoresarg
│ Main.java
│
├── controller
│ └── ProveedorController.java
│
├── dao
│ ├── IProveedorDAO.java
│ └── ProveedorDAO.java
│
├── db
│ └── ConexionDB.java
│
├── model
│ └── Proveedor.java
│
└── view
└── ProveedorView.java

yaml
Copiar código

---

## 🗄️ Base de Datos (MySQL)

El archivo incluido **script_bd.sql** crea la base y la tabla necesarias:

- Base: `bd_proveedoresarg`
- Tabla: `proveedores`

La tabla contiene campos como:
- id_proveedor  
- razon_social  
- cuit  
- email  
- telefono  
- provincia  
- fecha_registro  

La conexión a MySQL se configura en `ConexionDB.java`.

---

## ▶️ Cómo Ejecutar el Proyecto

1. Instalar MySQL y crear la base ejecutando `script_bd.sql`.
2. Configurar usuario y contraseña MySQL en:
src/com/proveedoresarg/db/ConexionDB.java

markdown
Copiar código
3. Compilar el proyecto en IntelliJ, NetBeans o cualquier IDE.
4. Ejecutar la clase:
Main.java

yaml
Copiar código
5. Navegar por el menú en la consola:
- Alta de proveedor  
- Búsqueda por nombre  
- Listado completo  

---

## 📦 Archivos Incluidos
- Código fuente Java completo  
- Diagrama UML del módulo (`diagrama_clases_prototipo.png`)  
- Script SQL  
- README.md  
- Estructura organizada según MVC  

---

## 👨‍💻 Autor
**Matías Ibañez**  
GitHub: https://github.com/matiibaniez  

---

## 🎓 Contexto Académico
Entrega correspondiente al **Trabajo Práctico AP4 – Seminario de Práctica Informática**,  
Universidad Siglo 21, Carrera Analista en Sistemas / Licenciatura en Informática.

---
