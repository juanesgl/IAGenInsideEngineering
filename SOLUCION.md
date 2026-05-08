## Ejercicio #1 

- Lo primero que hice fue darle el contexto a Gemini Pro para que me generara un prompt mucho más estable, y que le sirviera al Agente de Antigravity para que tuviera un mejor contexto.

- Prompt mejorado: 

  - Actúa como un Arquitecto de Software Senior y un experto instructor académico.

Contexto:
Estoy desarrollando un sistema de alquiler por consola llamado "El Videoclub de Don Mario". El objetivo principal no es solo que el código funcione, sino demostrar el dominio de la Programación Orientada a Objetos (POO), los principios SOLID y la correcta implementación de Patrones de Diseño.

Tarea:
Escribe el código completo y funcional en Java para este sistema y proporciona una explicación detallada de la arquitectura elegida.

Requerimientos Funcionales:

Gestionar un catálogo de películas predefinido:

[Física] Interestellar - $8.000 - Disponible

[Física] El Padrino - $7.000 - No disponible

[Digital] Inception - $5.000 - Disponible

[Digital] Matrix - $6.000 - Disponible

Permitir que el sistema procese el alquiler de X películas disponibles ingresando sus identificadores (ej. "1,3").

Calcular el precio total basándose en el tipo de membresía del cliente:

Básica: Sin descuento (precio normal).

Premium: 20% de descuento sobre el subtotal.

Imprimir un recibo final detallando: Cliente, listado de películas (con su tipo y precio), subtotal, descuento aplicado y total a pagar.

Restricciones Técnicas (ESTRICTAS):

Encapsulamiento y Polimorfismo: Usa clases abstractas o interfaces para los tipos de películas y membresías.

Patrones de Diseño: Debes implementar al menos dos patrones de diseño de manera explícita (por ejemplo, Strategy para el cálculo de descuentos y Factory Method para la creación de películas).

SOLID: El código debe respetar el Principio de Responsabilidad Única (SRP) y el Principio de Abierto/Cerrado (OCP). Evita el uso de sentencias if/else o switch masivas para calcular precios o instanciar tipos.

Ejecución: El programa debe contener un método main que simule el caso de uso exacto descrito en los requerimientos funcionales (Cliente Premium alquilando Interestellar e Inception) sin requerir entrada interactiva del teclado (Scanner), simulando directamente la ejecución por consola.

Formato de Salida Esperado:

Análisis Arquitectónico: Breve explicación (máximo 3 párrafos) identificando qué patrones de diseño utilizaste y cómo se aplican los principios SOLID, el polimorfismo y el encapsulamiento en tu solución.

Código Fuente: El código completo, limpio y documentado, preferiblemente organizado en un solo bloque (si el lenguaje lo permite) o separado por nombres de archivo claros.

Evidencia de Ejecución: Un bloque de texto simulando la salida exacta por consola generada por el método main. 