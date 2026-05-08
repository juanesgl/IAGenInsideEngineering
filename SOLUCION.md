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

--- 

## Ejercicio #2

- Agente utilizado: Gemini 3.1 Pro (High)
- Prompt propuesto para este ejercicio: 

- Tiempo gastado en el ejercicio: 24 minutos.

Actúa como un Tech Lead y Arquitecto de Software experto en Patrones de Diseño.
Contexto: Estoy trabajando en un ejercicio académico de refactorización para el sistema de pagos de una "Tienda Virtual". Tengo un código base que intenta implementar múltiples métodos de pago (Tarjeta, PayPal, Cripto) y un sistema de notificaciones (Inventario, Facturación, Email), pero contiene errores de compilación, de diseño arquitectónico y pruebas unitarias que fallan.
Tarea: Revisa el código base, los diagramas y las pruebas unitarias que te proporcionaré al final de este prompt. Analiza la implementación y ayúdame a agregar lo que se hizo en este ejercicio en el archivo SOLUCION.md respondiendo a los objetivos del ejercicio, además de entregar el código corregido.
Restricciones Técnicas (ESTRICTAS):
1. Patrones Esperados: La arquitectura sugiere la creación de familias de objetos (pago + validador), lo que implica un Abstract Factory. También sugiere la notificación automática a múltiples módulos, lo que implica un Observer. Centra tu análisis y correcciones estrictamente en implementar bien estos dos patrones.
2. No reescribas desde cero: Corrige los errores del código proporcionado. Añade solo las interfaces o clases que falten para cumplir los patrones, pero respeta la estructura base original.
3. SOLID: Asegúrate de que la solución final cumple con Open/Closed Principle (OCP) para permitir agregar nuevos métodos de pago en el futuro sin modificar el core.
4. El directorio en el que se encuentra la parte de código es en src/java/eci/edu/byteProgramming/ejercicio/paper/util
Formato de Salida Esperado (Genera el contenido para SOLUCION.md):
1. Análisis de Patrones
   • Identifica y justifica los dos patrones utilizados.
   • ¿Son adecuados? ¿Debería cambiar alguno?
2. Clases e Interfaces Faltantes
   • Lista y explica qué elementos arquitectónicos hacían falta en el código base para que los patrones funcionaran correctamente.
3. Validación del Diagrama de Contexto
   • Basado en la arquitectura final, indica si el diagrama original proporcionaba información suficiente. Documenta los cambios necesarios si los hay.
4. Identificación de Errores (Code Review)
   • Enumera los errores lógicos, de diseño o de compilación que encontraste en el código original y explica por qué no compilaba.
5. Código Corregido y Pruebas
   • Proporciona el código refactorizado y las pruebas unitarias corregidas para que pasen exitosamente.

Los diagramas se encuentran en la carpeta de docs/imagenes y docs/uml

--- 


### 1. Análisis de Patrones
- **Abstract Factory:** Se utilizó para crear "familias de objetos", en este caso, la combinación de un método de pago (ej. `CreditCardPayment`) y su respectivo validador (ej. `CreditCardValidator`). Este patrón es el adecuado porque asegura que el cliente (`ECIPayment`) siempre obtenga objetos compatibles entre sí (no se puede mezclar un pago de PayPal con un validador de Tarjeta).
- **Observer:** Se utilizó para notificar a múltiples módulos (Inventario, Facturación, Notificaciones por Email) de manera automática cuando un pago es procesado exitosamente o falla. Es el patrón ideal, ya que desacopla el núcleo de pagos (`ECIPayment`) de los procesos posteriores (post-pago), permitiendo agregar nuevos módulos interesados en el futuro sin modificar `ECIPayment`.

### 2. Clases e Interfaces Faltantes
- **`PaymentFactory` (Interfaz):** Faltaba la pieza central del Abstract Factory. Se creó para definir los métodos de creación de la familia: `createPaymentMethod()` y `createValidator()`.
- **Clases Concretas de Pago y Validación separadas:** Las clases originales (`CreditCardFactory`, `PaypalFactory`, etc.) intentaban ser fábricas, métodos de pago y validadores al mismo tiempo, violando el Principio de Responsabilidad Única. Se crearon las clases como `CreditCardPayment` y `CreditCardValidator`, dejando a `CreditCardFactory` como la verdadera fábrica concreta.

### 3. Validación del Diagrama de Contexto
- El diagrama de clases original proporcionaba la intención (mostrar una factoría de pagos), pero estructuralmente era incorrecto porque las fábricas extendían directamente de `PaymentMethod` y no definían la creación del validador como un producto separado de la familia.
- **Cambios necesarios en el diagrama:** Se debe introducir la interfaz `PaymentFactory` en la cima. Las fábricas concretas implementan esta interfaz y crean dos productos distintos: uno que implementa `PaymentMethod` y otro que implementa `ValidatePayment`. El diagrama de usuarios/Observer sí representaba adecuadamente la notificación a múltiples interesados.

### 4. Identificación de Errores (Code Review)
- **Error de Compilación 1:** La interfaz `PaymentFactory` requerida como parámetro en el método `processPayment` de `ECIPayment` no existía en el código.
- **Error de Compilación 2:** En `PaymentEventObserver.java` se había auto-importado `javax.management.Notification` en lugar de utilizar la clase local `Notification` creada en el paquete `util`. Esto causaba que no se encontraran los métodos `sendConfirmationEmail` y `sendFailureNotification`.
- **Error de Diseño (Nomenclatura y Roles):** Las clases como `CreditCardFactory` extendían de `PaymentMethod` e implementaban la lógica en lugar de encargarse únicamente de instanciar los objetos. Esto no es un Factory, rompe el patrón.
- **Error de Diseño (Acoplamiento de Validación):** `PaymentMethod` implementaba `ValidatePayment`. Si la validación pertenece a la familia de objetos creada por Abstract Factory, debe estar desacoplada del pago para que la fábrica cree el par `(Pago, Validador)`.

### 5. Código Corregido y Pruebas
Se reescribió la lógica para que `ECIPayment` utilice la factoría abstracta para obtener el pago y su validador y se añadieron pruebas unitarias para validar el flujo.

**Evidencia de Ejecución (Salida de JUnit):**
```text
🚀 ECI Payments: Starting payment process...
Customer: Juan Perez (juan@example.com)
Amount: $100.0
Description: Test Product
----------------------------------------
Processing Credit Card payment...
Contacting bank for card: **** **** **** 0123
Payment authorized by bank
Payment processed successfully!

Payment Observer: Processing successful payment events...
Inventory: Discounting 1 units of product PROD01
Facturation: Generating invoice for Juan Perez
   Amount: $100.0
   Product: Product
   Payment Method: CREDIT_CARD
Notification: Sending confirmation email
   To: juan@example.com
   From: noreply@eciPayments.com
   Subject: Payment Confirmation - TXN17782562342090086
   Dear Juan Perez,
   Your payment of $100.0 has been processed successfully via CREDIT_CARD
   Transaction ID: TXN17782562342090086
   Thank you for your purchase!
All post-payment processes completed successfully!

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
```
