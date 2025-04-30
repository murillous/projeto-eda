# Projeto EDA - Análise de Grafos Bipartidos com BFS

Este projeto implementa algoritmos para análise de grafos utilizando Busca em Largura (BFS), verificação de grafos bipartidos (coloração 2-graph), representação por matriz de adjacência e visualização gráfica.

## 📥 Download e Instalação

### Requisitos
- Java 21 ou superior instalado
- Terminal (Linux/macOS) ou Prompt de Comando/PowerShell (Windows)

### Baixando o Executável

1. Acesse o repositório: [https://github.com/murillous/projeto-eda](https://github.com/murillous/projeto-eda)
2. Clique na seção "Releases" no lado direito da página
3. Baixe o arquivo `projeto-executavel.jar` da release mais recente
4. Salve o arquivo em um diretório de sua preferência (ex: Área de Trabalho ou Desktop)

## ▶️ Como Executar o Programa

1. Abra o terminal (Linux/macOS) ou Prompt de Comando/PowerShell (Windows)
2. Navegue até o diretório onde você salvou o arquivo JAR
   ```
   cd caminho/para/diretorio
   ```
   
   Exemplos:
   - Windows: `cd C:\Users\SeuUsuario\Desktop`
   - macOS: `cd ~/Desktop`
   - Linux: `cd ~/Área\ de\ Trabalho` ou `cd ~/Desktop`

3. Execute o programa com o comando:
   ```
   java -jar projeto-executavel.jar
   ```

4. O programa solicitará o **caminho do arquivo de entrada** (um arquivo `.txt`):
   ```
   Digite o caminho do arquivo:
   ```

## 📁 Arquivo de Entrada

O arquivo de entrada deve ser um arquivo de texto (.txt) contendo a descrição do grafo a ser processado.

### Opções para fornecer o caminho do arquivo:

- **Mesmo diretório do JAR**: Digite apenas o nome do arquivo
  ```
  grafo.txt
  ```

- **Em uma pasta diferente (caminho relativo)**:
  ```
  dados/grafo.txt
  ```

- **Caminho absoluto**:
  - Windows: `C:/Users/SeuUsuario/Documents/grafo.txt`
  - Linux/macOS: `/home/seuusuario/Documents/grafo.txt`

## 🔍 Exemplo de Uso

1. Salve o arquivo JAR na Área de Trabalho
2. Crie um arquivo de texto chamado `grafo.txt` na mesma pasta com o seguinte conteúdo:
   ```
   ND
   A,B
   B,C
   C,D
   D,A
   A,C
   ```
3. Abra o terminal e navegue até a Área de Trabalho:
   ```
   cd ~/Desktop
   ```
4. Execute o programa:
   ```
   java -jar projeto-executavel.jar
   ```
5. Quando solicitado, digite o nome do arquivo:
   ```
   Digite o caminho do arquivo
   --> grafo.txt
   ```
6. O programa processará o grafo, verificará se é bipartido, exibirá a matriz de adjacência e mostrará a visualização gráfica do grafo

## ❓ Solução de Problemas

- Se você encontrar o erro "Java não é reconhecido...", verifique se o Java está instalado e configurado corretamente no PATH do sistema.
- Se receber "Arquivo não encontrado", verifique se digitou o caminho correto e se o arquivo existe naquele local.

## 📝 Formato do Arquivo de Entrada

O arquivo de texto (.txt) para entrada de dados deve seguir o seguinte formato:

1. **Primeira linha**: Define o tipo de grafo
   - `D` para grafo direcionado
   - `ND` para grafo não-direcionado

2. **Linhas seguintes**: Cada linha representa uma aresta do grafo
   - Formato: `Vértice1,Vértice2`
   - Os vértices devem ser separados por vírgula
   - Não deve haver espaços antes ou depois da vírgula

### Exemplo de arquivo para grafo não-direcionado:
```
ND
A,B
B,C
C,D
D,A
A,C
```

### Exemplo de arquivo para grafo direcionado:
```
D
A,B
B,C
C,A
D,B
A,D
```

Observações:
- Os vértices podem ser representados por letras ou números
- Cada aresta deve estar em uma linha separada
- O programa reconhecerá automaticamente os vértices a partir das arestas declaradas
