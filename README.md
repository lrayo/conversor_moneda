# Conversor de Monedas en Java

Este proyecto es un conversor de monedas simple desarrollado en Java que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real. El programa permite a los usuarios convertir cantidades entre diferentes monedas y proporciona un menú interactivo para seleccionar monedas de origen y destino.

## Características
- Conversión entre múltiples monedas utilizando datos en tiempo real de ExchangeRate-API.
- Menú interactivo para seleccionar moneda de origen y destino.
- Posibilidad de realizar múltiples conversiones en una sola ejecución.
- Manejo de errores para casos como monedas no soportadas o índices fuera de rango.

## Requisitos
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Versión 8 o superior).
- [ExchangeRate-API](https://www.exchangerate-api.com/): Necesitarás una clave de API para acceder a las tasas de cambio.
- Biblioteca `OkHttp` para solicitudes HTTP. Asegúrate de tenerla incluida en tu proyecto.

## Configuración
1. **Obtener clave de API**:
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una clave de API.
   - Guarda esta clave para usarla en el proyecto.
2. **Configurar entorno Java**:
   - Instala el JDK y configura tu entorno de desarrollo.
   - Asegúrate de que tu sistema tenga Java en el `PATH`.
3. **Agregar dependencias**:
   - Si usas Maven o Gradle, agrega la dependencia `OkHttp` a tu archivo de configuración.
   - De lo contrario, asegúrate de tener `OkHttp` disponible en tu entorno.

## Uso
1. **Ejecutar el programa**:
   - Compila y ejecuta el código Java.
   - Reemplaza `"TU_CLAVE_DE_API"` por tu clave de la API antes de ejecutar.
2. **Introducir detalles de conversión**:
   - Selecciona la moneda de origen y la moneda de destino del submenú.
   - Introduce la cantidad a convertir.
3. **Realizar conversión**:
   - El programa mostrará el resultado de la conversión.
4. **Continuar o salir**:
   - Después de la conversión, se te preguntará si deseas realizar otra conversión.
   - Introduce `1` para continuar o `0` para salir.

## Notas
- Este proyecto usa datos de terceros (ExchangeRate-API), por lo que está sujeto a las limitaciones y restricciones de uso de esa API.
- Asegúrate de no exceder los límites de uso gratuito si estás usando una cuenta gratuita.
- Los tipos de cambio pueden fluctuar, tenlo en cuenta al realizar conversiones.

## Contribuciones
- Si deseas contribuir a este proyecto, por favor abre un [issue](https://github.com/) o envía un [pull request](https://github.com/).

## Licencia
Este proyecto está bajo la [Licencia MIT](https://opensource.org/licenses/MIT). Consulta el archivo `LICENSE` para más detalles.
