# D.O.O---Tarea-3

**Integrantes:**
* Antonio Benavides
* Maria Jose San Martin
* Valeria Quiroga

Este proyecto consiste en simular el funcionamiento de una maquína expendedora
que permite a los usuarios seleccionar y comprar productos, gestionar monedas 
y reabastecer productos en la máquina expendedora.

Algunas de las caracteristicas del proyecto son:
* Posee interfaz gráfica construida con Swing.
* Gestión de productos y monedas.
* Simulación realista de una máquina expendedora.
* Posibilidad de reabastecer productos.
* Efectos de sonido al interactuar con la máquina.

El proyecto está dividido en dos partes:
1. **logica_expendedor:** Contiene la lógica de la máquina expendedora, incluyendo la gestión 
de productos, monedas y excepciones.
    * Excepciones: Contiene clases de excepción específicas para manejar errores comunes 
    durante la interacción con la máquina.
    * Monedas: Clases que definen diferentes tipos de monedas aceptadas por la máquina, 
    cada una con su propio valor.
    * Productos: Contiene la definición abstracta y la gestión de productos que pueden 
    ser comprados desde la máquina.

2. **logica_interfaz:** Contiene la lógica de la interfaz gráfica de usuario, incluyendo paneles, 
botones y sonidos.
   * PanelComprador, PanelExpendedor, PanelProductos: Representan los componentes visuales de 
   la interfaz de usuario para mostrar productos, la máquina expendedora y las acciones del 
   comprador respectivamente.
   * Sonidos: Gestiona los efectos de sonido para mejorar la experiencia del usuario durante 
   la interacción con la máquina.
   * Ventana: La clase principal que inicializa la interfaz gráfica y gestiona su funcionamiento.


![](C:\Users\Maria Jose\Desktop\programar\java\interfaz.jpeg)
