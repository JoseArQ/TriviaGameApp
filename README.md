# TriviaGameApp
Challenge: juego de preguntas y respuestas en java
# Requerimientos 
Java: JDK11
Jar Sqlite 3: http://www.java2s.com/Code/Jar/s/Downloadsqlitejdbc372jar.htm

# Para tener en cuenta

Verificar que el arichivo de la base de datos TriviaGameDB se encuentre en la carpeta del proyecto.

Verificar que el jar de sqlite-jdbc también se encuntre en la carpeta del proyecto. 

Verificar que se instale la libreria jar en proyecto.

Rectificar la ruta de la base de datos en el archivo Conexion.java
ubicado en el folder util en mi caso la ruta es: 

/home/jose/NetBeansProjects/TriviaGameApp/TriviaGameDB

por lo tanto la variable strConexionDB queda como sigue

String strConexionDB = "jdbc:sqlite:/home/jose/NetBeansProjects/TriviaGameApp/TriviaGameDB";

Segun la ubicación de la carpeta en el equipo debe modificarse esa variable escribiendo jdbc:sqlite:ruta_de_la_ubicacion_base_de_datos

