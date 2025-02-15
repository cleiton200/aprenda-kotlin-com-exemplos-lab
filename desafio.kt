enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }
    
    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        for (inscrito in inscritos) {
            println(inscrito.nome)
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val cursoKotlin = ConteudoEducacional("Introdução ao Kotlin", 90)
    val cursoAvancado = ConteudoEducacional("Kotlin Avançado", 120)

    val formacaoKotlin = Formacao("Desenvolvimento Kotlin", listOf(cursoKotlin, cursoAvancado), Nivel.INTERMEDIARIO)

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.listarInscritos()
}
