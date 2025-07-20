data class Aluno (val nome: String)
data class ConteudoEducacional(val nome:String)

class Formacao(val nome: String, val nivel: String, val conteudos: List<ConteudoEducacional>){
    val alunosMatriculados = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        alunosMatriculados.add(aluno)
        println("Aluno ${aluno.nome} matriculado na formação $nome.")
    }
    
    fun matricular(alunos: List<Aluno>) {
        alunosMatriculados.addAll(alunos)
        println("${alunos.size} alunos matriculados na formação $nome.")
    }
    
    fun listarAlunos(){
        if(alunosMatriculados.isEmpty()){
            println("Nenhum aluno matriculado nesta formação ainda.")
        }else{
            println("Alunos matriculados na formação $nome:")
            alunosMatriculados.forEach { aluno ->
                println("- ${aluno.nome}")
            }
        }
    }
}

fun main() {
    // 1.Vou aqui Criar alguns conteúdos educacionais
   val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin")
   val kotlinPOO = ConteudoEducacional("Programação Orientada a Objetos com Kotlin")
   val kotlinFundamentos = ConteudoEducacional("Fundamentos de Desenvolvimento Android")
    
     val formacaoAndroid = Formacao(
    nome = "Formação Desenvolvedor Android",
    nivel = "Intermediário",
    conteudos = listOf(kotlinBasico, kotlinPOO, kotlinFundamentos)
    )
    
    println("Formação criada: ${formacaoAndroid.nome} - Nível: ${formacaoAndroid.nivel}")
    println("Conteúdos da formação:")
    formacaoAndroid.conteudos.forEach { conteudo ->
        println("- ${conteudo.nome}")
    }
    println("---")
    
    // 3. Criar alguns alunos
    val aluno1 = Aluno("João Silva")
    val aluno2 = Aluno("Maria Souza")
    val aluno3 = Aluno("Pedro Mendes")
    
    
    // 4. Matricular alunos na formação
    formacaoAndroid.matricular(aluno1)
    formacaoAndroid.matricular(aluno2)
    
    println("---\n")
    formacaoAndroid.listarAlunos()
    
    println("---\n")
    formacaoAndroid.matricular(listOf(aluno3))
    
    println("---\n")
    formacaoAndroid.listarAlunos() 
}