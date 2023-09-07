// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val matricula: Int){
    override fun toString() : String{
        return "Nome do usuario: $nome; Matrícula: $matricula"
    }
    
    init {
        println("Novo usuário criado: ${this}")
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel){
    override fun toString() : String {
        return "Nome do conteúdo: $nome; Duração: $duracao; Nível: ${nivel.toString().lowercase()}"
    }
    
    init{
         println("Novo conteúdo adicionado: $nome")
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
       inscritos.add(usuario)
       println("Usuário matriculado: ${usuario.nome}")
       println("Matrícula: ${usuario.matricula}")
    }
    
    fun matricular(usuarios : List<Usuario>) {
        inscritos.addAll(usuarios)
        println("Usuários matriculados via lista: ")
        usuarios.forEach {
          println("Usuário matriculado: ${it.nome}")
          println("Matrícula: ${it.matricula}")
        }
    }
    
    init{
        println("Nova formação adicionada: $nome")
    	println("Nova formação com os seguintes cursos: ")
        this.conteudos.forEach {
            println(it.toString())
        }
    }
}

fun main() {
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val novoConteudoIntermediario = ConteudoEducacional("Testes Automatizados", 180, Nivel.INTERMEDIARIO)

    val novoConteudoBasico = ConteudoEducacional("Introdução á lógica", 30, Nivel.BASICO)

    val novoConteudoAvancado = ConteudoEducacional("Modularização", 80, Nivel.AVANCADO)

    val listaNovosConteudos = mutableListOf<ConteudoEducacional>(novoConteudoIntermediario, novoConteudoBasico, novoConteudoAvancado)
    
    val novaFormacao = Formacao("Formação Android", listaNovosConteudos)
        
    val user1 = Usuario("Maria", 12349)
    	
    
    val user2 = Usuario("João", 1234567)

    val user3 = Usuario("José", 23456)

    val user4 = Usuario("Mariana", 456789)

    val usuarios = listOf<Usuario>(user2, user3, user4)
        
    novaFormacao.matricular(user1)
    
    novaFormacao.matricular(usuarios)


    
}
