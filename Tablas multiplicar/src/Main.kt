import java.security.InvalidKeyException

/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 * @param num Int - número que retornará
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(): Int {
    val min = 1
    val max = 100
    var num = 0
    do {
        try {
            print("Introduce un número entre 1 y 100: ")
            num = readln().toInt()
            if ((num < 1 || num > 100)) {
                println("Número inválido, inténtalo de nuevo.")
            }
        } catch (e: NumberFormatException) {
            println("Número inválido, inténtalo de nuevo.")
        }
    } while ((num < 1 || num > 100))
    return num
}
/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(pregunta: String): Boolean{
    var respuesta = ""
    do {
        try {
            print(pregunta)
            var respuesta = readln()
            if (respuesta == "n") {
                return false
            }
            else if (respuesta == "s") {
                break
            }
            else {
                println("Respuesta inválida, vuelve a intentarlo.")
            }
        } catch (e: NumberFormatException){
            println("Respuesta inválida, vuelve a intentarlo.")
        }
    } while ((respuesta != "s" || respuesta != "n"))
    return true
}

fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    var respuesta = true
    while (respuesta == true) {
        val num = pedirNum()
        var multiplicaciones = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var cont = 0
        println("La tabla de multiplicar del número $num es:")
        while (cont < 10) {
            var res = num * multiplicaciones[cont]
            cont++
            println("$cont -> $num * $cont = $res")
        }
        respuesta = pregunta("¿Desea generar otra tabla de multiplicación? (s/n): ")
    }
}