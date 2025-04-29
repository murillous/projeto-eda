# 📄 Instruções de Execução

## Requisitos

-   Java 21 ou superior instalado na máquina.

-   Terminal (Linux/macOS) ou Prompt de Comando/PowerShell (Windows).
## Como Executar

1.  Compile o projeto e gere o arquivo `.jar` (já realizado).

2.  Para rodar o programa, use o seguinte comando no terminal:
    `java -jar projeto-eda.jar`
3.  O programa solicitará o **caminho do arquivo de entrada** (um arquivo `.txt`).

    -   Se o arquivo `.txt` estiver **no mesmo diretório** que o `.jar`, basta digitar apenas o nome do arquivo:
        `meu_arquivo.txt`

    -   Se o arquivo estiver em outra pasta, informe o **caminho relativo**:
        `arquivos/meu_arquivo.txt`
    -   Ou o **caminho absoluto**, conforme o sistema operacional:

        -   Windows:
            `C:/Users/SeuUsuario/Documents/meu_arquivo.txt`

        -   Linux/macOS:
            `/home/seuusuario/Documents/meu_arquivo.txt`

## Exemplo de Execução
```
java -jar projeto-eda.jar
Digite o caminho do arquivo 
--> grafo.txt
```