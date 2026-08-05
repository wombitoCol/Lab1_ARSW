# Lab uno ARSW

- Juan Diego Patiño Muñoz
- Julio Cesar Mayorquin Rodriguez 

# Preguntas

- Cambie el incio con 'start()' por 'run()'. Cómo cambia la salida?, por qué?.

## 3 Punto

<img width="1289" height="889" alt="imagen" src="https://github.com/user-attachments/assets/7816442e-9797-4d59-beb0-0d32a8fc9bf4" />
1 hilo

<img width="1291" height="882" alt="imagen" src="https://github.com/user-attachments/assets/dc131b42-d96c-4e7b-b91e-53cd889e3056" />
Tanto hilos como nucleos

<img width="1286" height="883" alt="imagen" src="https://github.com/user-attachments/assets/09aee80c-c310-430b-b5da-12e1f12876ca" />
Doble de hilos que de nucleos

<img width="1283" height="884" alt="imagen" src="https://github.com/user-attachments/assets/87d3a591-979c-4c19-b9dd-3ef8f4e2ece1" />
50 hilos

<img width="1286" height="887" alt="imagen" src="https://github.com/user-attachments/assets/1b561284-6db3-48e8-8a02-c2764f99e019" />
100 hilos


## 4 Punto 

<img width="190" height="66" alt="imagen" src="https://github.com/user-attachments/assets/e67200c4-7f6a-4de2-be7c-070975998ef5" />
Teniendo esta formula y entendiendo que S(N) es el la diferencia de tiempo entre 1 hilo y n hilos. Usamos entonces N(s) = T(1)/T(s), y para calcular este tiempo hay un metodo del paquete system el cual permite calcular tiempos en milisegundos siendo este "nanoTime()" asi pues el codigo quedaria de la siguiente forma:
<img width="1135" height="583" alt="imagen" src="https://github.com/user-attachments/assets/2d0f997e-84bf-47e3-bc5e-004a4db47ed8" />
el output dado es:

````
Núcleos detectados: 12
ago 04, 2026 8:58:24 P. M. edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade reportAsNotTrustworthy
INFORMACIÓN: HOST 200.24.34.55 Reported as NOT trustworthy
Hilos: 1    -> Tiempo: 4,209284 s
ago 04, 2026 8:58:25 P. M. edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade reportAsNotTrustworthy
INFORMACIÓN: HOST 200.24.34.55 Reported as NOT trustworthy
Hilos: 12   -> Tiempo: 0,345536 s
ago 04, 2026 8:58:25 P. M. edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade reportAsNotTrustworthy
INFORMACIÓN: HOST 200.24.34.55 Reported as NOT trustworthy
Hilos: 24   -> Tiempo: 0,149459 s
ago 04, 2026 8:58:25 P. M. edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade reportAsNotTrustworthy
INFORMACIÓN: HOST 200.24.34.55 Reported as NOT trustworthy
Hilos: 200  -> Tiempo: 0,063730 s
ago 04, 2026 8:58:25 P. M. edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade reportAsNotTrustworthy
INFORMACIÓN: HOST 200.24.34.55 Reported as NOT trustworthy
Hilos: 500  -> Tiempo: 0,053141 s
````
Y listo, con esto podemos ver que:

S(200) = 4,240816/0,05555 = 76,40559239

S(500) = 4,240816/0,053866 = 78,72899417

Que es la cantidad que mejora respecto a un hilo.

Notamos algo muy curioso, y es que la mejora entre los 200 hilos y los 500 hilos es MÍNIMA, sabiendo que 500 es más del doble de 200. Esto sucede a razón de los núcleos que usa mi computadora, que son 12, y estos tienen un límite de procesamiento de núcleos, el cual hace que esta ley se vea afectada en sus mejoras a más hilos.

Ahora, si analizamos el caso de los hilos iguales a los núcleos y el doble de hilos que de núcleos, como podemos observar, el input nos dio los resultados en tiempo, entonces solo queda hacer la fórmula y comparar:

S(12) = 12,27315244

S(24) = 28,37444383

Entonces, con esta información vemos que sí hay una mejora ENORME (mayor al doble) respecto a los mismos núcleos que al doble de estos. Ahora, entonces, cabe concluir que sí existen grandes mejoras, incluso sobrepasando los núcleos del sistema, pero que estas mejoras no son exponenciales aumentando siempre los núcleos al infinito.

Ahora, en un caso hipotético donde 100 computadoras funcionaran con un solo hilo, esta limitación vista arriba desaparecería, ya que la p... La razón es que estos números se están viendo limitados por los núcleos del procesador, ya que los procesos paralelos no se están dando en cada núcleo, sino que este está dando un "context switching", o sea, que no es un proceso paralelo, más bien son los núcleos partiendo el proceso en varios pedacitos y completándolo por partes. Si pudiéramos asignarle a cada hilo un procesador, esto no limitaría los tiempos de cómputo que un solo procesador con sus núcleos físicos puede manejar. Y el caso de 100/c sería el caso más óptimo, ya que vimos que sí existe una mejora al aumentar los núcleos, teniendo límites cuando se sobrepasan estos; estamos en un caso de optimización máxima.
_TODO_

