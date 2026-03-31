Antonia Cáceres - 22.050.742-4 - antoniacaceress
Benjamín Carrasco - 21.983.969-3 - benjamincarrasco02-lab

Descripción del proyecto:
A partir de las instrucciones que se nos entregaron, se creó un programa de lenguaje java el cual funciona como un menú para acceder a datos de usuarios desde un archivo txt, 
y por otro lado, datos de un archivo txt que contiene la información respecto a las actividades que cada usuario realizó en su dispositivo móvil.
A la hora de querer acceder a los datos por cada usuario, el programa solicita credenciales únicas para cada uno, las cuales posteriormente nos permite modificar, siempre
y cuando la contraseña anterior de cada usuario sea correcta. Además, en un menú de análisis de los datos, podemos agregar actividades no registradas, como también podemos
modificarlas, permitiéndonos cambiar las horas utilizadas para cada actividad, la fecha de realización e incluso la misma actividad.
Además, el programa es capaz de comparar los datos de todos los usuarios y posteriormente nos puede entregar comparaciones tales como el usuario que mas procastinó, así como 
la actividad más realizada por cada usuario.
Por último, este programa es capaz de mostrarnos los cambios a través de la muestra de todas las actividades si es que el usuario así lo desea. 

Estructura del proyecto:
Se utilizó una sola clase la cual se denominó taller1.
Se utilizaron métodos tales como:
-abrirArchUsuarios(), abrirArchRegistros(), reescribirTXT1(), reescribirTXT2(). Estos son los métodos fundamentales del programa, ya que sin estos, ningún otro método 
funcionaria correctamente.
-menuPrincipal(), menuUsuarios(), menuAnalisis(). Estos fueron utilizados para permitirnos realizar cualquier función que el taller requería, empezando por verificarUsuarios(), 
el cual nos permite verificar la identidad del usuario pidiéndonos usuario y contraseña, antes de entrar al menú de usuarios.
-Luego tenemos los métodos que se crearon para utilizar correctamente el menú de usuarios, los cuales fueron:
registrarActividad(), modificarActividad(), eliminarActividad() y cambiarContraseña().
-Por último, los métodos creados para el trabajo correcto del menú de análisis fueron:
verTodas(), actividadMasRealizada(), actividadMasRealizadaPorCadaUsuario(), usuarioMasProcrastinacion().


Instrucciones de ejecución: 
Antes que todo, se debe tener java instalado y actualizado en el computador, y también los archivos de texto (Registros.txt y Usuarios.txt) descargados y asociados a la 
clase donde se trabajará el programa.
Ahora bien, dependiendo de lo que la persona que vaya a utilizar este programa quiera hacer, debe seguir las instrucciones que se leen desde el menú, en donde se especifica dentro
del menú de usuarios las opciones: Usuario, contraseña, registrar, modificar y eliminar alguna actividad, y por último, antes de la opción salir, encontramos la opción 
de cambiar la contraseña.
Por otro lado, si se elige el menú de análisis, encontramos las siguientes opciones: actividad más realizada, actividad más realizada por cada usuario, usuario con mayor
procrastinación, y por último, antes de la opción salir la cual nos devuelve al menú principal, encontramos mostrar todas las actividades, en donde se incluirá cualquier
modificación en alguna de estas. 
