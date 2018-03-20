# AseguradosIMMS
Programa calculador de nss y verificador de tarjetas de credito
basado en:
http://elconta.com/2010/08/28/como-se-saca-integra-el-numero-del-imss/
https://www.pcihispano.com/el-algoritmo-de-luhn-y-su-importancia-para-la-validacion-de-tarjetas-de-pago/
se hace uso de la siguiente libreria
https://commons.apache.org/proper/commons-csv/download_csv.cgi

al generar el .jar se pasan de la siguiente forma los parametros:

$java -jar proyecto.jar -i archivoEntrada.csv -o archivoSalida.csv

El archivo datos.csv muestra el formato que debe tener el archivo
